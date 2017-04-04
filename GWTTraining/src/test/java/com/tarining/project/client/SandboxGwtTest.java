package com.tarining.project.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.tarining.project.GWTTraining";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
