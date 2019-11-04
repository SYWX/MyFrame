package com.smm.framework.authority;

import lombok.Data;

/**
 * @author CHX
 * @description
 * @date 2019-11-04
 */
@Data
public class CloseAuthorityEvironment {

    public CloseAuthorityEvironment(){
        super();
    }

    public CloseAuthorityEvironment(String currentRunEnvironment, String closeAuthEnvironment) {
        this.currentRunEnvironment = currentRunEnvironment;
        this.closeAuthEnvironment = closeAuthEnvironment;
    }

    private String currentRunEnvironment;

    private String closeAuthEnvironment;

    public String getCurrentRunEnvironment() {
        return currentRunEnvironment;
    }

    public void setCurrentRunEnvironment(String currentRunEnvironment) {
        this.currentRunEnvironment = currentRunEnvironment;
    }

    public String getCloseAuthEnvironment() {
        return closeAuthEnvironment;
    }

    public void setCloseAuthEnvironment(String closeAuthEnvironment) {
        this.closeAuthEnvironment = closeAuthEnvironment;
    }
}
