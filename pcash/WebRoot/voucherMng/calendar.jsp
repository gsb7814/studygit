<%@ page language="java" pageEncoding="utf-8"%>
<link rel="stylesheet" type="text/css" media="all"
	href="calender/themes/system.css" title="Calendar Theme - system.css" />
<link href="calender/doc/css/zpcal.css" rel="stylesheet" type="text/css" />

<!-- import the calendar script -->
<script type="text/javascript" src="calender/src/utils.js"></script>
<script type="text/javascript" src="calender/src/calendar.js"></script>

<!-- import the language module -->
<script type="text/javascript" src="calender/lang/calendar-zh.js"></script>
<script type="text/javascript" src="calender/src/calendar-setup.js"></script>


<style type="text/css">


         /*
         Define elements to show start/end dates and the dates in between
         */

         /*
         * for start/end dates
         */
         .edges {
            border : 1px solid;
            border-color: #adaa9c #fff #fff #adaa9c;
            background-color: #fffbee;
         }

         /*
         * for dates between start and end dates
         */
         .between {
            background-color: #dccdb9;
         }

         .calendar tbody .disabled { text-decoration: line-through; color:#000}
      </style>

开始时间：
<input type="text" name="voucherMngBean.fromDate" id="departure_date" size="11"
	onfocus="this.blur()" style="width:100" readonly value=""/>
结束时间：
<input type="text" name="voucherMngBean.toDate" id="arrivalDate" size="11"
	onfocus="this.blur()" style="width:100" readonly value=""/>

<script type="text/javascript">
		<!--  to hide script contents from old browsers
			var startDate;
			var endDate;
			var callbacks = 0;

			function resetDates() {
				startDate = endDate = null;
			}


			/*
			* Given two dates (in seconds) find out if date1 is bigger, date2 is bigger or
			 * they're the same, taking only the dates, not the time into account.
			 * In other words, different times on the same date returns equal.
			 * returns -1 for date1 bigger, 1 for date2 is bigger 0 for equal
			 */

			function compareDatesOnly(date1, date2) {
				var year1 = date1.getYear();
				var year2 = date2.getYear();
				var month1 = date1.getMonth();
				var month2 = date2.getMonth();
				var day1 = date1.getDate();
				var day2 = date2.getDate();

				if (year1 > year2) {
					return -1;
				}
				if (year2 > year1) {
					return 1;
				}

				//years are equal
				if (month1 > month2) {
					return -1;
				}
				if (month2 > month1) {
					return 1;
				}

				//years and months are equal
				if (day1 > day2) {
					return -1;
				}
				if (day2 > day1) {
					return 1;
				}

				//days are equal
				return 0;


				/* Can't do this because of timezone issues
				var days1 = Math.floor(date1.getTime()/Date.DAY);
				var days2 = Math.floor(date2.getTime()/Date.DAY);
				return (days1 - days2);
				*/
			}

			function filterDates1(cal) {
				startDate = cal.date;
				/* If they haven't chosen an 
				end date before we'll set it to the same date as the start date This
				way if the user scrolls in the start date 5 months forward, they don't
				need to do it again for the end date.
				*/

				if (endDate == null) { 
					Zapatec.Calendar.setup({
						inputField     :    "arrivalDate",
						button         :    "button8b",  // What will trigger the popup of the calendar
						ifFormat       :    "%Y-%m-%d ",
						timeFormat     :    "24",
						date           :     startDate,
						electric       :     false,
						showsTime      :     false,          //no time
						disableFunc    :    dateInRange2, //the function to call
						onUpdate       :    filterDates2
					});
				}
			}

			function filterDates2(cal) {
				endDate = cal.date;
			}

			/*
			* Both functions disable and hilight dates.
			*/
			
			/* 
			* Can't choose days after the
			* end date if it is choosen, hilights start and end dates with one style and dates between them with another
			*/
			function dateInRange1(date) {

				if (endDate != null) {

					// Disable dates after end date
					var compareEnd = compareDatesOnly(date, endDate);
					if  (compareEnd < 0) {
						return (true);
					}

					// Hilight end date with "edges" style
					if  (compareEnd == 0) {
						{return "edges";}
					}


					// Hilight inner dates with "between" style
					if (startDate != null){
						var compareStart = compareDatesOnly(date, startDate);
						if  (compareStart < 0) {
							return "between";
						} 
					} 
				}

				//disable days prior to today
				//var today = new Date();
				//var compareToday = compareDatesOnly(date, today);
				//if (compareToday > 0) {
				//	return(true);
				//}


				//all other days are enabled
				return false;
				//alert(ret + " " + today + ":" + date + ":" + compareToday + ":" + days1 + ":" + days2);
				return(ret);
			}

			/* 
			* Can't choose days before the
			* start date if it is choosen, hilights start and end dates with one style and dates between them with another
			*/

			function dateInRange2(date) {
				if (startDate != null) {
					// Disable dates before start date
					var compareDays = compareDatesOnly(startDate, date);
					if  (compareDays < 0) {
						return (true);
					}

					// Hilight end date with "edges" style
					if  (compareDays == 0) {
						{return "edges";}
					}

					// Hilight inner dates with "between" style
					if ((endDate != null) && (date > startDate) && (date < endDate)) {
						return "between";
					} 
				} 

				//var now = new Date();
				//if (compareDatesOnly(now, date) < 0) {
				//	return (true);
				//}

				//all other days are enabled
				return false;
			}
			// end hiding contents from old browsers  -->
	</script>


<script type="text/javascript">
		var cal = new Zapatec.Calendar.setup({
		
				inputField     :    "departure_date",   // id of the input field
				button         :    "button8a",  // What will trigger the popup of the calendar
				ifFormat       :    "%Y-%m-%d ",       //  of the input field
				timeFormat     :    "24",
				showsTime      :     false,          //no time
				electric       :     false,
				dateStatusFunc :    dateInRange1, //the function to call
				onUpdate       :    filterDates1
			
		});
		
			Zapatec.Calendar.setup({
				inputField     :    "arrivalDate",
				button         :    "button8b",  // What will trigger the popup of the calendar
				ifFormat       :    "%Y-%m-%d ",
				timeFormat     :    "24",
				showsTime      :     false,          //no time
				electric       :     false,
				dateStatusFunc :    dateInRange2, //the function to call
				onUpdate       :    filterDates2
			});
			
	</script>
