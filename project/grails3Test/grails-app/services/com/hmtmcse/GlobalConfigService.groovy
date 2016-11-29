package com.hmtmcse


class GlobalConfigService {

    def itemsPerPage() {
        return 100;
    }

    public static String getUID(){
        return UUID.randomUUID().toString().toUpperCase();
    }

}
