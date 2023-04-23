package org.lineageos.settings.device;

public class Constants {
    public static final String KEY_REFRESH_RATE_CONFIG = "pref_refresh_rate_config";
    public static final String KEY_REFRESH_RATE_INFO = "pref_refresh_rate_info";
    public static final String KEY_DC_DIMMING = "pref_dc_dimming";
    public static final String REFRESH_RATE_SWITCH_SUMMARY = "enable_high_refresh_rate_summary";
    public static final float[] REFRESH_RATES = {60.0f, 120.0f};
    public static final float DEFAULT_REFRESH_RATE = REFRESH_RATES[1];

    public static final String DISPPARAM_NODE = "/sys/devices/platform/soc/ae00000.qcom,mdss_mdp/drm/card0/card0-DSI-1/disp_param";
    public static final String BRIGHTNESS_NODE = "/sys/devices/platform/soc/ae00000.qcom,mdss_mdp/backlight/panel0-backlight/brightness";

    public static final String DISPPARAM_DC_ON = "0x40000";
    public static final String DISPPARAM_DC_OFF = "0x50000";

    public static final String DEFAULT_REFRESH_RATE_CONFIG = "120-120";
        
    public static final String KEY_HEADPHONE_GAIN = "headphone_gain";
    public static final String HEADPHONE_GAIN_NODE = "/sys/kernel/sound_control/headphone_gain";
    public static final String KEY_MICROPHONE_GAIN = "microphone_gain";
    public static final String MICROPHONE_GAIN_NODE = "/sys/kernel/sound_control/mic_gain";
    public static final String KEY_SPEAKER_GAIN = "speaker_gain";
    public static final String SPEAKER_GAIN_NODE = "/sys/kernel/sound_control/speaker_gain";
    
    public static final String KEY_KPROFILES_AUTO = "pref_kprofiles_auto";
    public static final String KPROFILES_AUTO_NODE = "/sys/module/kprofiles/parameters/auto_kprofiles";
    public static final String KEY_KPROFILES_MODES = "pref_kprofiles_modes";
    public static final String KPROFILES_MODES_NODE = "/sys/module/kprofiles/parameters/kp_mode";
    public static final String KPROFILES_MODES_INFO = "pref_kprofiles_modes_info";
}
