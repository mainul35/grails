/**
 * Created by touhid on 30/08/2015.
 */

jQuery(document).ready(function () {


    jQuery('.delete-confirmation').confirm({
        title: 'Delete Confirmation!',
        content: 'Are you sure want to delete?'
    });

    jQuery('.card-body').on('click', '.add-new-number ', function () {
        var _this = jQuery(this);
        GT.ajax.call({
            url: GT.baseURL + "contactNumber/number",
            dataType: "html",
            success: function (content) {
                jQuery('.number-panel').append(content);
                _this.removeClass("add-new-number");
                _this.removeClass("btn-primary");
                _this.addClass("remove-number");
                _this.addClass("btn-danger");
                _this.find(".fa").removeClass("fa-plus-circle");
                _this.find(".fa").addClass("fa-remove");
            }
        });
    });

    jQuery('.card-body').on('click', '.remove-number', function () {
        var _this = jQuery(this);
        _this.closest(".form-group").remove();
    });


});
