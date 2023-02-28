package com.timesheet.presentation.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.timesheet.datamodel.User;
import com.timesheet.presentation.repository.SessionRepo;

//@WebFilter(filterName = "loginFilter", urlPatterns = { "*.xhtml", "*.html" })

public class LoginFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);

	public static final String LOGIN_PAGE = "/pages/login.html";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		HttpSession ses = httpServletRequest.getSession(false);

		String reqURI = httpServletRequest.getRequestURI();
		// managed bean name is exactly the session attribute name
		if (!reqURI.contains(LOGIN_PAGE)) {

			if (ses != null) {
				if (ses.getAttribute("currentUser") != null) {
					User user = (User) ses.getAttribute("currentUser");
					SessionRepo sessionRepo = (SessionRepo) ses.getAttribute("sessionRepo");
					String s = sessionRepo.findSessionIdByUser(user);
					if (ses.getId().equals(s)) {

						LOGGER.debug("user is logged in");
						// user is logged in, continue request
						filterChain.doFilter(servletRequest, servletResponse);
						return;
					} else {
						LOGGER.debug("user is not logged in");
						// user is not logged in, redirect to login page
						httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);

					}

				} else {
					LOGGER.debug("user is not logged in");
					// user is not logged in, redirect to login page
					httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
				}
			} else {
				LOGGER.debug("userManager not found");
				// user is not logged in, redirect to login page
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
			}
		} else

		{
			filterChain.doFilter(servletRequest, servletResponse);

		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.debug("LoginFilter initialized");
	}

	@Override
	public void destroy() {
		// close resources
	}

}