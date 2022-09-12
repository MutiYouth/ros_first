package com.weng.ros_first.ros_integrate;

import com.intellij.spellchecker.BundledDictionaryProvider;

/**
 * loads the ROS bundled dictionary into the IDE.
 * This dictionary holds commonly used ROS terms that are not standard English.
 * @author Noam Dori
 */
public class ROSBundledDictionaryProvider implements BundledDictionaryProvider {
    @Override
    public String[] getBundledDictionaries() {
        return new String[] {"ros.dic"};
    }
}
