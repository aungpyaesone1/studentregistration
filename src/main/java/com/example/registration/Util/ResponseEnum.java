package com.example.registration.Util;

public class ResponseMessageEnum {
    public enum ResponseStatus{
        SAVE_SUCCESS("Successfully Saved"),
        SAVE_FAIL("Save Fail"),
        UPDATE_SUCCESS("Successfully Updated"),
        UPDATE_FAIL("Update Fail"),
        DELETE_SUCCESS("Successfully Deleted"),
        DELETE_FAIL("Delete Fail"),
        NOT_FOUND("Item not found"),
        SUCCESS("Success"),
        FAIL("Fail"),
        INVALID_REQUEST("Invalid request");

        String value;

        ResponseStatus (String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum ResponseCode{

    }
}
