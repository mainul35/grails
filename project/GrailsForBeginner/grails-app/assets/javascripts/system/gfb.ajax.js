/**
 * Created with IntelliJ IDEA.
 * User: H.M.Touhid MIa
 */

GFB.ajax = (function(){

    return{

        call: function(settings){
           var defaults = {
               url:null,
               method:"POST",
               dataType:"html",
               afterComplete:null,
               beforeSubmit:null,
               success:null,
               callBackF:null,
               mask:".mask",
               data:null
           }

            if(settings){
                jQuery.extend(defaults, settings);
            }

            jQuery.ajax({
                url:defaults.url,
                type:defaults.method,
                dataType:defaults.dataType,
                data: defaults.data,
                beforeSend:function(){
                    jQuery(defaults.mask).show();
                },
                success:function(content){
                    if(defaults.callBackF){
                        defaults.callBackF(content);
                    }
                },
                complete:function(){
                    jQuery(defaults.mask).hide();
                }
            });
        }
    }
}());