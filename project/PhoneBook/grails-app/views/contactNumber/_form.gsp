<div class="form-group">
    <div class="form-inline phone-number-area">
        <div class="form-group">
            <UIHelper:contactType value="${number?.type}" name="number.type"/>
        </div>
        <div class="form-group mx-sm-3">
            <g:textField name="number.number" class="form-control" placeholder="Phone Number" value="${number?.number}"/>
        </div>
        <g:if test="${number}">
            <button type="button" class="btn btn-danger remove-number"><i class="fa  fa-remove fa-lg"></i></button>
        </g:if>
        <g:else>
            <button type="button" class="btn btn-primary add-new-number"><i class="fa  fa-plus-circle fa-lg"></i></button>
        </g:else>

    </div>
</div>
