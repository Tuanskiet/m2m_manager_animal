package com.poly.World_animal.contansts;

public class Message {
    public enum User {
        PASS_NOT_MATCH("Mật khẩu không khớp!"),
        EMAIL_ALREADY_EXITS("Email Đã tồn tại!"),
        USER_REGISTER_SUCCESS("Đăng ký tài khoản thành công!");

        private String code;

        User(String value) {
            this.code = value;
        }

        public String getCode() {
            return this.code;
        }
    }

        public enum User1{
            PASS_NOT_MATCH("Mật khẩu không khớp!"),
            EMAIL_ALREADY_EXITS ("Email Đã tồn tại!"),
            USER_REGISTER_SUCCESS("Đăng ký tài khoản thành công!");

            private String  code;
            User1(String value) {
                this.code = value;
            }
            public String getCode(){
                return this.code;
            }

    }


}
