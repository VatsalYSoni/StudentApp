package com.demo.utils;

import static android.os.Environment.getExternalStorageDirectory;

public final class AppConstants {

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "mindorks_mvvm.db";

    public static final long NULL_INDEX = -1L;

    public static final String PREF_NAME = "mindorks_pref";

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";

    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";

    public static final String STATUS_CODE_FAILED = "failed";

    public static final String STATUS_CODE_SUCCESS = "success";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }


    public static final String MENU = "Menu";
    public static final String DASHBOARD = "Dashboard";
    public static final String START_NEW_LOAD = "Start New Load";
    public static final String LOAD_HISTORY = "Load History";
    public static final String MY_MESSAGES = "My Messages";
    public static final String NOTIFICATION = "Notification";
    public static final String MY_PROFILE = "My Profile";
    public static final String UPLOAD_DOCUMENT = "Upload Document";
    public static final String SETTINGS = "Settings";
    public static final String ABOUT_INSTITUTE = "About Institute";
    public static final String CONTACT = "Contact";
    public static final String RETURNABLE = "Returnable";
    public static final String ISSUE = "Issue";
    public static final String RESULT = "Result";
    public static final String ASSIGNMENT = "Assignment";
    public static final String NOTICE = "Notice";
    public static final String LOGOUT = "Logout";

    public final static String PROFILE_PICTURE = getExternalStorageDirectory() + "/OTR/ProfilePicture/";
    public final static String ISSUE_IMAGE = getExternalStorageDirectory() + "/OTR/RaiseAnIssue/";
}