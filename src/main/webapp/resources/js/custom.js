/*$(function() {

 $.each($('.ui-paginator-current'), function(index, value) {

 var text=$(this).text().replace('of' , 'من');
 $(this).text(text);
 });

 });*/

$(document).on(
		'click',
		'.ui-selectcheckboxmenu',
		function() {
			if ($('body').attr('dir') === 'RTL') {
				var select = $(this).attr('id') + "_panel";
				var r = ($(window).width() - ($(this).offset().left + $(this)
						.outerWidth()));
				/* select = $(PrimeFaces.escapeClientId(select)); */
				select = '#' + select.replace(/:/g, "\\:");
				var width = $(this).find('.ui-selectonemenu-label').width();
				setTimeout(function() {
					$(select).css('right', r);
					$(select).css('left', '');
					var len = $(select).find(
							'.ui-selectonemenu-filter-container').length;
					if (len > 0) {

						$(select).attr(
								'style',
								$(select).attr('style') + '; ' + 'width:'
										+ width + 'px!important');
					} else {
						$(select).attr(
								'style',
								$(select).attr('style') + '; ' + 'width:'
										+ width + 'px!important');

					}
				}, 1);
			}

		});

$(document).on(
		'click',
		'.hasDatepicker',
		function() {
			if ($('body').attr('dir') === 'RTL') {
				console.log($(this));
				var select = "ui-datepicker-div";
				var r = ($(window).width() - ($(this).offset().left + $(this)
						.outerWidth()));
				console.log(r);
				/* select = $(PrimeFaces.escapeClientId(select)); */
				select = '#' + select.replace(/:/g, "\\:");

				setTimeout(function() {
					$(select).css('right', r);
					$(select).css('left', '');

				}, 1);
			}

		});

$(function() {

	if ($('body').attr('dir') === 'RTL') {

		PrimeFaces.locales['ar'] = {
			closeText : 'إغلق',
			prevText : 'إلى الخلف',
			nextText : 'إلى الأمام',
			currentText : 'بداية',
			monthNames : [ 'كانون الثاني', 'شباط', 'آذار', 'نيسان', 'أيار',
					'حزيران', 'تموز', 'آب', 'أيلول', 'تشرين الأول',
					'تشرين الثاني', 'كانون الأول' ],
			monthNamesShort : [ 'كانون الثاني', 'شباط', 'آذار', 'نيسان',
					'أيار', 'حزيران', 'تموز', 'آب', 'أيلول', 'تشرين الأول',
					'تشرين الثاني', 'كانون الأول' ],
			dayNames : [ 'يوم الأحد‎', 'يوم الإثنين‎', 'يوم الثلاثاء‎',
					'‏يوم الأَرْبعاء‎', '‏يوم الخَمِيس‎', 'يوم الجُمْعَة‎‎',
					'يوم السَّبْت' ],
			dayNamesShort : [ 'الأحد‎', 'الإثنين‎', 'الثلاثاء‎', 'الأَرْبعاء‎',
					'الخَمِيس‎', 'الجُمْعَة‎‎', 'السَّبْت' ],
			dayNamesMin : [ 'الأحد‎', 'الإثنين‎', 'الثلاثاء‎', 'الأَرْبعاء‎',
					'الخَمِيس‎', 'الجُمْعَة‎‎', 'السَّبْت' ],
			weekHeader : 'الأسبوع',
			firstDay : 6,
			isRTL : true,
			showMonthAfterYear : true,
			yearSuffix : '',
			timeOnlyTitle : 'الوقت فقط',
			timeText : 'الوقت',
			hourText : 'ساعة',
			minuteText : 'دقيقة',
			secondText : 'ثانية',
			ampm : true,
			month : 'الشهر',
			week : 'الأسبوع',
			day : 'اليوم',
			allDayText : 'سا ئر اليوم'
		};
	}
	$('.fc-view').css('direction', 'rtl!important');

});
