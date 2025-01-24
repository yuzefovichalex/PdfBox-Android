package com.tom_roush.pdfbox.android;

import java.util.HashMap;
import java.util.Map;

public class PDFBoxConfig
{
    /**
     * Enum to represent what fonts PDFBox should attempt to load
     */
    public enum FontLoadLevel
    {
        /**
         * Load and process all available fonts
         */
        FULL,

        /**
         * Load and process only the minimum fonts required to maintain functionality
         */
        MINIMUM,

        /**
         * Do not load any fonts (May cause crashes)
         */
        NONE
    }

    /**
     * Option to disable searching the file system for fonts (Speeds up startup if fonts not needed)
     */
    public static FontLoadLevel FONT_LOAD_LEVEL = FontLoadLevel.MINIMUM;

    private static final HashMap<String, String> customFonts = new HashMap<>();

    private static boolean debugLoggingEnabled = false;

    /**
     * @return the current FontLoadLevel
     */
    public static FontLoadLevel getFontLoadLevel()
    {
        return FONT_LOAD_LEVEL;
    }

    /**
     * @param fontLoadLevel the new FontLoadLevel to use when loading fonts
     */
    public static void setFontLoadLevel(FontLoadLevel fontLoadLevel)
    {
        FONT_LOAD_LEVEL = fontLoadLevel;
    }

    /**
     * @return User defined custom fonts.
     * */
    public static Map<String, String> getCustomFonts() {
        return customFonts;
    }

    /**
     * Add additional font to be used in font mapping. The custom fonts are loaded independently
     * from the specified font load level. The font should be added before document is loaded.
     * */
    public static void addCustomFont(String name, String path) {
        customFonts.put(name, path);
    }

    /**
     * @param debugLoggingEnabled sets whether debug logging is enabled for PdfBox-Android
     */
    public static void setDebugLoggingEnabled(boolean debugLoggingEnabled)
    {
        PDFBoxConfig.debugLoggingEnabled = debugLoggingEnabled;
    }

    /**
     * @return whether debug logging is enabled for PdfBox-Android
     */
    public static boolean isDebugEnabled()
    {
        return debugLoggingEnabled;
    }
}
