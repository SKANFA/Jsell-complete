/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.config;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jdcs_dev
 */
public class DbConfig {

    @Getter
    @Setter
    private String hubHost = "127.0.0.1";
    @Getter
    @Setter
    private int hubPort = 40000;

}
