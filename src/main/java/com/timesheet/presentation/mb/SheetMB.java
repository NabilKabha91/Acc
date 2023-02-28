/**
 * 
 */
package com.timesheet.presentation.mb;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.util.CollectionUtils;

import com.timesheet.datamodel.AgentsInfo;
import com.timesheet.datamodel.Month;
import com.timesheet.datamodel.Office;
import com.timesheet.datamodel.ServiceType;
import com.timesheet.datamodel.SheetDetails;
import com.timesheet.datamodel.User;
import com.timesheet.datamodel.WorkingDays;
import com.timesheet.presentation.repository.AgentRepo;
import com.timesheet.presentation.repository.MonthRepo;
import com.timesheet.presentation.repository.ServiceTypeRepo;
import com.timesheet.presentation.repository.SheetDetailRepo;
import com.timesheet.presentation.repository.UserRepo;
import com.timesheet.presentation.service.HolidayService;
import com.timesheet.utils.JsfUtils;
import com.timesheet.utils.MessageBundle;
import com.timesheet.utils.Utils;

/**
 * @author Malek
 *
 */
@ManagedBean
@ViewScoped

public class SheetMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1340260644039013801L;
	/**
	 * 
	 */

	@ManagedProperty(value = "#{sheetDetailRepo}")
	private SheetDetailRepo sheetDetailRepo;
	@ManagedProperty(value = "#{agentRepo}")
	private AgentRepo agentRepo;
	@ManagedProperty(value = "#{userRepo}")
	private UserRepo userRepo;
	@ManagedProperty(value = "#{serviceTypeRepo}")
	private ServiceTypeRepo serviceTypeRepo;
	@ManagedProperty(value = "#{monthRepo}")
	private MonthRepo monthRepo;

	@ManagedProperty(value = "#{holidayService}")
	private HolidayService holidayService;

	private List<SheetDetails> sheetDetails = new ArrayList<SheetDetails>();
	private List<AgentsInfo> agents = new ArrayList<AgentsInfo>();
	private List<AgentsInfo> selectedAgents = new ArrayList<AgentsInfo>();
	private List<ServiceType> serviceType = new ArrayList<ServiceType>();

	private Date fromDate = new Date();
	private Date toDate = new Date();
	private List<User> users = new ArrayList<User>();
	private User currentUser;
	private long officeHour;

	private Date todayDate = new Date();
	private Date mineDate = new Date();
	private Date maxDate = new Date();
	private int currentMonth;
	private int activeIndex;
	private int selectedMonth;
	private int currentYear;
	private int currentDayWeek;
	private String todayName;
	private List<Month> months = new ArrayList<Month>();

	private Office currentOffice;

	@PostConstruct
	public void ini() {

		this.currentUser = Utils.getCurrentUser();
		this.currentOffice = Utils.getCurrentOffice();
		this.users.add(currentUser);
		if (this.currentUser.isSuperUser()) {
			List<User> usersChild = userRepo.findByParentUser(currentUser);
			if (!CollectionUtils.isEmpty(usersChild)) {
				this.users.addAll(usersChild);
			}
		}
		this.agents = agentRepo.findAllByOffice(Utils.getCurrentOffice());
		// addNewDetails();
		this.officeHour = (long) Utils.getCurrentOffice().getOfficeHour();
		this.serviceType = this.serviceTypeRepo.findAll();

		Calendar cal = Calendar.getInstance();
		this.currentDayWeek = cal.get(Calendar.DAY_OF_WEEK);
		// currentDay = cal.get(Calendar.DAY_OF_MONTH);
		this.currentMonth = cal.get(Calendar.MONTH);
		this.activeIndex = this.currentMonth;
		this.currentYear = cal.get(Calendar.YEAR);
		this.todayName = Utils.getDayName(currentDayWeek - 1);
		findByMonth(currentMonth + 1);

		months = new ArrayList<Month>();
		for (int i = 1; i <= 12; i++) {

			Month month = monthRepo.findByMonthAndYearAndOffice(i, currentYear, currentOffice);
			if (null == month) {
				month = new Month();
				month.setMonth(i);
				if (currentMonth + 1 < i) {
					month.setClose(true);
				}
			}

			months.add(month);
		}

	}

	public void findByMonth(int selectedMonth) {
		preapareMinAndMAxDate(selectedMonth);
		sheetDetails = sheetDetailRepo.findByMonthAndYearForUser(selectedMonth, this.currentYear, currentUser.getId());

	}

	private void preapareMinAndMAxDate(int selectedMonth) {
		Calendar cal = Calendar.getInstance();
		cal.set(currentYear, selectedMonth - 1, 1);
		mineDate = cal.getTime();
		if (currentMonth == selectedMonth - 1) {
			maxDate = new Date();

		} else {
			cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, selectedMonth - 1);
			cal.set(Calendar.DATE, 1);
			cal.set(Calendar.MONTH, selectedMonth);
			cal.set(Calendar.YEAR, currentYear);
			cal.add(Calendar.DATE, -1);
			maxDate = cal.getTime();
		}

		this.selectedMonth = selectedMonth;
	}

	@SuppressWarnings("deprecation")
	public void addNewDetails() {
		SheetDetails sheetDetails = new SheetDetails();
//		sheetDetails.setFromHour(new Time(8, 0, 0));
//		sheetDetails.setToHour(new Time((int) (8 + officeHour), 0, 0));
		sheetDetails.setUser(currentUser);
		sheetDetails.setUserType(currentUser.getUserType());
		calcHourse(sheetDetails);
		this.sheetDetails.add(sheetDetails);

	}

	private void calcHourse(SheetDetails sheetDetails) {
		calcTotlalHours(sheetDetails);
		calcOverTimeHours(sheetDetails);
		calcOfficialHours(sheetDetails);
	}

	public void deleteDetail(SheetDetails sheetDetail) {
		sheetDetailRepo.delete(sheetDetail);
		sheetDetails.remove(sheetDetail);

	}

	public void calcOfficialHours(SheetDetails sheetDetails2) {

		boolean workDay = isWorkDay(sheetDetails2);
		if (null != sheetDetails2.getFromHour() && null != sheetDetails2.getToHour()) {

			if (workDay) {
				long secs = (sheetDetails2.getToHour().getTime() - sheetDetails2.getFromHour().getTime()) / 1000;
				if (secs > officeHour * 3600L) {
					secs = secs - (secs - officeHour * 3600L);
				}
				sheetDetails2.setOfficialHours(secs);
			}
	
			else {
				sheetDetails2.setOfficialHours(0L);
	
			}
		}
	}

	public List<ServiceType> getListServiceType(SheetDetails sheetDetails) {

		return sheetDetails.getYear().getYearServicesType();

	}

	@SuppressWarnings("deprecation")
	private boolean isWorkDay(SheetDetails sheetDetails2) {
		boolean workDay = true;

		if (sheetDetails2.getTodayDate() != null) {
			workDay = holidayService.findByOfficeAndStartDateOrEndDate(currentOffice, sheetDetails2.getTodayDate());
			if (workDay) {
				for (WorkingDays workingDays : currentOffice.getWorkingDays()) {
					if (sheetDetails2.getTodayDate().getDay() == workingDays.getDay()) {
						workDay = workingDays.isActiveDay();
						officeHour = workingDays.getWorkingHours()!=null ? workingDays.getWorkingHours().longValue():0L ;
						break;
					}
				}
			}
		}
		return workDay;
	}

	public void calcTotlalHours(SheetDetails sheetDetails2) {
		sheetDetails2.setTotalOverTime(0L);
		if (null != sheetDetails2.getFromHour() && null != sheetDetails2.getToHour()) {
			long secs = (sheetDetails2.getToHour().getTime() - sheetDetails2.getFromHour().getTime()) / 1000;
			sheetDetails2.setTotalHours(secs);
		}

	}

	public void calcOverTimeHours(SheetDetails sheetDetails2) {

		if (!isWorkDay(sheetDetails2)) {
			officeHour = 0;
		}
		sheetDetails2.setTotalOverTime(0L);
		long totalFromHour = 0;
		long totaltoHour = 0;
		long totaltOverHour = 0;
		if (null != sheetDetails2.getFromHour() && null != sheetDetails2.getToHour()) {
			for(SheetDetails dtl : getSheetDetails()) {
				if(sheetDetails2.getTodayDate().equals(dtl.getTodayDate())) {
					totalFromHour+= dtl.getFromHour().getTime();
					totaltoHour+= dtl.getToHour().getTime();
					totaltOverHour+=dtl.getTotalOverTime();
				}
			}
			if (null != sheetDetails2.getFromHour() && null != sheetDetails2.getToHour()) {
				long secs = (totaltoHour - totalFromHour) / 1000;
				if (secs > (officeHour * 3600L)) {
					secs = secs - officeHour * 3600;
					sheetDetails2.setTotalOverTime(secs- totaltOverHour);
				}
			}
		}

	}

	public void checkDate(SheetDetails sheetDetails) {
		if (null != sheetDetails.getFromHour() && null != sheetDetails.getToHour()) {
			if(checkDateFomTo(sheetDetails)) {
				calcHourse(sheetDetails);
				boolean before = sheetDetails.getToHour().before(sheetDetails.getFromHour());
				if (before) {
					sheetDetails.setToHour(null);
					JsfUtils.addErrorMessage(MessageBundle.getMsg("checkWorkingHours"));
				}
			}else {
				sheetDetails.setFromHour(null);
				sheetDetails.setToHour(null);
			}
		}

	}
	
	private boolean checkDateFomTo(SheetDetails sheetDetails) {
		boolean valid = true;
		int obIndex = getSheetDetails().indexOf(sheetDetails);
		if (null != sheetDetails.getFromHour() && null != sheetDetails.getToHour()) {
			for(int index = 0; index < getSheetDetails().size() ; index++)
				if(index != obIndex) {
					if(getSheetDetails().get(index).getTodayDate().equals(sheetDetails.getTodayDate())) {
						if(sheetDetails.getToHour().getTime()<=getSheetDetails().get(index).getToHour().getTime()
								&& sheetDetails.getFromHour().getTime()>=getSheetDetails().get(index).getFromHour().getTime()) {
							valid = false;
							break;
						}
						
					}
				}
		}
		return valid;
	}

	public void save() {

		if (CollectionUtils.isEmpty(sheetDetails)) {
			JsfUtils.addErrorMessage(MessageBundle.getMsg("notHaveData"));

			return;
		}

		sheetDetailRepo.save(sheetDetails);
		JsfUtils.addSuccessMessage(MessageBundle.getMsg("success"));

	}

	public void search() {

		if (selectedAgents == null || selectedAgents.isEmpty()) {
			// sheetDetails = sheetDetailRepo.findByTodayDateBetween(fromDate,
			// toDate);
		} else {
			sheetDetails = sheetDetailRepo.findByTodayDateBetweenAndAgentIn(fromDate, toDate, selectedAgents);
		}

	}

	/**
	 * @return the sheetDetailRepo
	 */
	public SheetDetailRepo getSheetDetailRepo() {
		return sheetDetailRepo;
	}

	/**
	 * @param sheetDetailRepo
	 *            the sheetDetailRepo to set
	 */
	public void setSheetDetailRepo(SheetDetailRepo sheetDetailRepo) {
		this.sheetDetailRepo = sheetDetailRepo;
	}

	/**
	 * @return the agentRepo
	 */
	public AgentRepo getAgentRepo() {
		return agentRepo;
	}

	/**
	 * @param agentRepo
	 *            the agentRepo to set
	 */
	public void setAgentRepo(AgentRepo agentRepo) {
		this.agentRepo = agentRepo;
	}

	/**
	 * @return the userRepo
	 */
	public UserRepo getUserRepo() {
		return userRepo;
	}

	/**
	 * @param userRepo
	 *            the userRepo to set
	 */
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	/**
	 * @return the serviceTypeRepo
	 */
	public ServiceTypeRepo getServiceTypeRepo() {
		return serviceTypeRepo;
	}

	/**
	 * @param serviceTypeRepo
	 *            the serviceTypeRepo to set
	 */
	public void setServiceTypeRepo(ServiceTypeRepo serviceTypeRepo) {
		this.serviceTypeRepo = serviceTypeRepo;
	}

	/**
	 * @return the sheetDetails
	 */
	public List<SheetDetails> getSheetDetails() {
		return sheetDetails;
	}

	/**
	 * @param sheetDetails
	 *            the sheetDetails to set
	 */
	public void setSheetDetails(List<SheetDetails> sheetDetails) {
		this.sheetDetails = sheetDetails;
	}

	/**
	 * @return the agents
	 */
	public List<AgentsInfo> getAgents() {
		return agents;
	}

	/**
	 * @param agents
	 *            the agents to set
	 */
	public void setAgents(List<AgentsInfo> agents) {
		this.agents = agents;
	}

	/**
	 * @return the selectedAgents
	 */
	public List<AgentsInfo> getSelectedAgents() {
		return selectedAgents;
	}

	/**
	 * @param selectedAgents
	 *            the selectedAgents to set
	 */
	public void setSelectedAgents(List<AgentsInfo> selectedAgents) {
		this.selectedAgents = selectedAgents;
	}

	/**
	 * @return the serviceType
	 */
	public List<ServiceType> getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType
	 *            the serviceType to set
	 */
	public void setServiceType(List<ServiceType> serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate
	 *            the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param currentUser
	 *            the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @return the officeHour
	 */
	public long getOfficeHour() {
		return officeHour;
	}

	/**
	 * @param officeHour
	 *            the officeHour to set
	 */
	public void setOfficeHour(long officeHour) {
		this.officeHour = officeHour;
	}

	/**
	 * @return the todayDate
	 */
	public Date getTodayDate() {
		return todayDate;
	}

	/**
	 * @param todayDate
	 *            the todayDate to set
	 */
	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}

	/**
	 * @return the currentMonth
	 */
	public int getCurrentMonth() {
		return currentMonth;
	}

	/**
	 * @param currentMonth
	 *            the currentMonth to set
	 */
	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	/**
	 * @return the selectedMonth
	 */
	public int getSelectedMonth() {
		return selectedMonth;
	}

	/**
	 * @param selectedMonth
	 *            the selectedMonth to set
	 */
	public void setSelectedMonth(int selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	/**
	 * @return the currentYear
	 */
	public int getCurrentYear() {
		return currentYear;
	}

	/**
	 * @param currentYear
	 *            the currentYear to set
	 */
	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	/**
	 * @return the currentDay
	 */
	public int getCurrentDay() {
		return currentDayWeek;
	}

	/**
	 * @param currentDay
	 *            the currentDay to set
	 */
	public void setCurrentDayWeek(int currentDay) {
		this.currentDayWeek = currentDay;
	}

	/**
	 * @return the todayName
	 */
	public String getTodayName() {
		return todayName;
	}

	/**
	 * @param todayName
	 *            the todayName to set
	 */
	public void setTodayName(String todayName) {
		this.todayName = todayName;
	}

	/**
	 * @return the mineDate
	 */
	public Date getMineDate() {
		return mineDate;
	}

	/**
	 * @param mineDate
	 *            the mineDate to set
	 */
	public void setMineDate(Date mineDate) {
		this.mineDate = mineDate;
	}

	/**
	 * @return the maxDate
	 */
	public Date getMaxDate() {
		return maxDate;
	}

	/**
	 * @param maxDate
	 *            the maxDate to set
	 */
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	/**
	 * @return the currentOffice
	 */
	public Office getCurrentOffice() {
		return currentOffice;
	}

	/**
	 * @param currentOffice
	 *            the currentOffice to set
	 */
	public void setCurrentOffice(Office currentOffice) {
		this.currentOffice = currentOffice;
	}

	/**
	 * @return the monthRepo
	 */
	public MonthRepo getMonthRepo() {
		return monthRepo;
	}

	/**
	 * @param monthRepo
	 *            the monthRepo to set
	 */
	public void setMonthRepo(MonthRepo monthRepo) {
		this.monthRepo = monthRepo;
	}

	/**
	 * @return the months
	 */
	public List<Month> getMonths() {
		return months;
	}

	/**
	 * @param months
	 *            the months to set
	 */
	public void setMonths(List<Month> months) {
		this.months = months;
	}

	/**
	 * @return the activeIndex
	 */
	public int getActiveIndex() {
		return activeIndex;
	}

	/**
	 * @param activeIndex
	 *            the activeIndex to set
	 */
	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}

	/**
	 * @return the holidayService
	 */
	public HolidayService getHolidayService() {
		return holidayService;
	}

	/**
	 * @param holidayService
	 *            the holidayService to set
	 */
	public void setHolidayService(HolidayService holidayService) {
		this.holidayService = holidayService;
	}

}
