$(document).on('keypress', '.quantity', function(e) {
    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        return false;
    }
});

$(document).on('click', '.hidebtn', function(e) {
    var hidden = $('.menuTd1');
    $(this).addClass('show');
    $(this).removeClass('hidebtn');
    hidden.hide('slide', {
        direction: 'right'
    }, 500);
    $('.menuTd').css('width', '30px');
});

$(document).on('click', '.show', function(e) {
    var hidden = $('.menuTd1');
    $(this).addClass('hidebtn');
    $(this).removeClass('show');
    hidden.show('slide', {
        direction: 'right'
    }, 500);
    $('.menuTd').css('width', '230px')
});
$(document).on('keydown', '.inputToSum', function(e) {
    // 
    // Allow: backspace, delete, tab, escape, enter and .
    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 116]) !== -1 ||
        (e.keyCode === 65 && e.ctrlKey === true) ||
        (e.keyCode === 67 && e.ctrlKey === true) ||
        (e.keyCode === 88 && e.ctrlKey === true) ||
        (e.keyCode >= 35 && e.keyCode <= 39)) {
        return;
    }
    if (e.keyCode === 110) {
        var inp = $(this).val();
        if (inp.indexOf('.') > -1) {
            e.preventDefault();
        }
        return;

    }
    if (e.keyCode === 109 || e.keyCode === 189) {
        var inp = $(this).val();
        if (inp) {
            if (inp.indexOf('-') !== -1) {
                e.preventDefault();
            } else {
                $(this).val('-' + $(this).val());
                $(this).change();
            }
        } else {
            return;
        }
    }
    // Ensure that it is a number and stop the keypress
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
        e.preventDefault();
    }
});

var options = {};
$(document).on('click', '.advance .btn-c', function() {
    $(this).parent().find('.fa-minus').toggle();
    $(this).parent().find('.fa-plus').toggle();
    $(this).parent().find(".advCustom").toggle('blind', options, 500);
});

$(function() {
    $('#width').val($(window).width());
    $('#height').val($(window).height());
    unselect();
    //To solve problem when show page in FramDilog
    try {
        var $input = $('<button id="frmReport:temp" name="frmReport:temp" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btnTemp" onclick="PrimeFaces.ab({s:&quot;frmReport:temp&quot;,p:&quot;@none&quot;,u:&quot;@none&quot;,g:false,ps:true});return false;" type="submit" role="button" aria-disabled="false"><span class="ui-button-text ui-c">temp</span></button>				');
        $input.appendTo($("body"));
        setTimeout(
            function() {
                $('.btnTemp').click();
                $('.btnTemp').remove();
            }, 100);
    } catch (e) {
        // TODO: handle exception
    }
});

$(document).on('click1111', '.btn-save, .btn-view', function(e) {
    $('html,body').animate({
        scrollTop: 0
    }, 700);
});

var message = "يوجد بيانات لم يتم حفظها هل أنت متأكد من الخروج؟ ";
var on;
// Set the unload message whenever any input element get changed.
$(document).on('change', 'input,.ui-inputfield', function() {
    on = true;
});
$(document).on('keypress', 'input,textarea,.ui-inputfield,.cke_editable', function() {
    on = true;
});
$(document).on('click', '.container button,.container .ui-datepicker-trigger ', function() {
    on = true;
});

$(document).on('click', '.btn-close', function(e) {
	 try {
    if (on) {
        PF('confirmClose').show();
    } else {
        confirmClose();
    }
	 
} catch (ex) {
	console.log(ex);
}
});

function setOff() {
    on = false;
}
function setOn() {
    on = true;
}
function unselect() {
    $.each($('.ui-panelmenu-panel'), function(index, value) {
        if ($(this).find('a').hasClass('active')) {
            $(this).find(".ui-panelmenu-content").css("display", "none"); //shows the menuitems
            $(this).find(".ui-panelmenu-content").show();
            $(this).find(".ui-panelmenu-header").addClass("ui-state-active"); //sets the submenu header to active state
            $(this).find(".ui-icon-triangle-1-e").addClass("ui-icon-triangle-1-e").removeClass("ui-icon-triangle-1-s"); //sets the triangle icon to "expaned" version
        }
    });
}
$(document).on('click', '.ui-panelmenu-panel', function(e) {
    $('.ui-panelmenu-panel').removeClass('active');
    $(this).addClass('active');
    $.each($('.ui-panelmenu-panel'), function(index, value) {
        if (!$(this).hasClass("active")) {
            $(this).find(".ui-panelmenu-content").css("display", "none"); //shows the menuitems
            $(this).find(".ui-panelmenu-header").removeClass("ui-state-active"); //sets the submenu header to active state
            $(this).find(".ui-icon-triangle-1-e").removeClass("ui-icon-triangle-1-e").addClass("ui-icon-triangle-1-s"); //sets the triangle icon to "expaned" version
        }
    });
});

$(document).on(
    'click',
    '.ui-selectonemenu',
    function() {
    	
    	try {
        if ($('body').attr('dir').toUpperCase() === 'RTL') {}
        var select = $(this).attr('id') + "_panel";
        var r = ($(window).width() - ($(this).offset().left + $(this).outerWidth()));
        /* select = $(PrimeFaces.escapeClientId(select)); */
        select = '#' + select.replace(/:/g, "\\:");
        var width = $(this).find('.ui-selectonemenu-label').width();
        setTimeout(function() {
            $(select).css('right', r);
            $(select).css('left', '');
            var len = $(select).find('.ui-selectonemenu-filter-container').length;
            if (len > 0) {
                //	$(select).attr(	'style',$(select).attr('style') + '; ' + 'width:'+ width + 'px!important');
            } else {
                //	$(select).attr(	'style',$(select).attr('style') + '; ' + 'width:'+ width + 'px!important');
            }
        }, 10);
    	} catch (ex) {
    	}
    });
$(document).ready(function() {
	if (window.location.href.indexOf('localhost') < 0) {
    	connectioncheck({
            frequency: 10,
            remotepole: true,
            inputstodisable: ["body", "click"]
        });
    }
	
});

/**
 * @author Timothy Svecz
 *
 *
 * Use under MIT-License This is the only file neededed.
 */
/**
 * The code below uses setinterval to send an ajax request at specified
 * intervals and then do stuff based on the status
 */
var currentstatus = 0;
var frequency = 10;
var remotepole = false;
var remoteaddress = "http://laurelwreath-jo.com/ASA-TEST/resources/images/logo_1.png";
var errormessage = "Connection to the server has been interupted. Please Try Again.";
var usenativediv = true;
var foreigndivid = "myDIVid";
var inputstodisable = "";
var connectionaddress = "";

function connectioncheck(options) {
    var options = options || {};
    frequency = options.frequency || 10;
    remotepole = options.remotepole || false;
    remoteaddress = options.remoteaddress || "http://laurelwreath-jo.com/ASA-TEST/resources/images/logo_1.png";
    errormessage = options.errormessage || "Connection to the server has been interupted. Please Try Again.";
    usenativediv = options.usenativediv || true;
    foreigndivid = options.foreigndivid || "myDIVid";
    inputstodisable = options.inputstodisable;
    if (usenativediv == false) {
        $('#' + foreigndivid).hide();
    }
    if (!remotepole) {
        connectionaddress = document.URL;
    } else {
        connectionaddress = remoteaddress;
    }
    setInterval(function() {
        var activeRequest = false;
        if (!activeRequest) {
            activeRequest = true;
            var request = $.ajax({
                url: connectionaddress,
                type: "HEAD",
                cache: !1,
                success: function(result) {
                    activeRequest = false;
                    handleStatus(1);
                },
                error: function(textStatus) {
                    activeRequest = false;
                    handleStatus(0);
                }
            });
            return request;
        }
    }, frequency * 1000);
};

function handleStatus(status) {
    if (status === 1) {

        if (inputstodisable != null && inputstodisable.length > 0) {
            $.each(inputstodisable, function(index, value) {
                $('input[type=' + value + ']').attr('disabled', false);
            });
        }
        if (usenativediv == true) {
            $('#alertdiv').remove();
        } else {
            $('#' + foreigndivid).hide();
        }

        currentstatus = 1;
    } else {
        if (inputstodisable != null && inputstodisable.length > 0) {
            $.each(inputstodisable, function(index, value) {
                $('input[type=' + value + ']').attr('disabled', true);
            });
        }
        if (usenativediv == true) {
        	
        	var thediv= "<div id='alertdiv' class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-shadow ui-hidden-container TxtCenter' style='width: auto; height: auto; left: 537.5px; top: 272px; z-index: 1006; display: block;' role='dialog' aria-labelledby='j_idt1423_title' aria-hidden='false' aria-live='polite'><div class='ui-dialog-content ui-widget-content' style='height: auto;'><span class='red Fs40 pulse-ring  fa fa-info-circle'></span>			<br><span class='red Fs30'>لا يوجد اتصال بالإنترنت</span></div></div>";
        	
           // var thediv = "<div style='position:fixed;bottom:0;left:0px;text-align:center;font-size:35px;background-color:#EACBCB;color:#BF6566;z-index:9;width:100%;' id='alertdiv' >" + errormessage + "</div>";
            $('body').append($(thediv));
        } else {
            $('#' + foreigndivid).show();
        }
        currentstatus = 0;

    }
}