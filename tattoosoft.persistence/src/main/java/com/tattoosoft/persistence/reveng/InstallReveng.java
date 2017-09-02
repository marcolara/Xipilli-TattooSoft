package com.tattoosoft.persistence.reveng;

import com.xipilli.persistence.reveng.InstallRevengOutput;

/**
 * Install reveng output from the src/util source folder into the src source
 * folder. Handles package name refactoring for pojo class files as well since
 * they come from dao and end up in model.
 */
public class InstallReveng {
    public static void main(String[] args) {
		InstallRevengOutput install = new InstallRevengOutput(true, "/Users/marcolara/git/Xipilli-TattooSoft", "tattoosoft.persistence", "com.tattoosoft.persistence", "com/tattoosoft/persistence");
		install.install();
    }
}
