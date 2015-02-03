/**
 * Created by pradyumna on 02-02-2015.
 */
require(["bootstrap-datepicker"], function(boot) {
    alert(boot);
    $('#datetimepicker1').datepicker({
        format: "dd/mm/yyyy",
        orientation: "top auto",
        clearBtn: true,
        autoclose: true
    });

});

