package com.technorizen.doctorgodoctor.Constant;

public class BaseClass {
    private String BaseUrl = "https://insys.com.sv/crysco/webservice/";

    public static BaseClass get() {
        return new BaseClass();
    }

    public String Login() {
        return BaseUrl.concat("login");
    }

    public String registerMobile() {
        return BaseUrl.concat("register_mobile");
    }

    public String checkOtp() {
        return BaseUrl.concat("check_otp");
    }

    public String resendOtp() {
        return BaseUrl.concat("resend_otp");
    }

    public String updateProfile() {
        return BaseUrl.concat("update_profile");
    }
}
