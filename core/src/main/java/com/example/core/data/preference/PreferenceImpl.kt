package com.example.core.data.preference

import android.content.SharedPreferences
import com.example.core.domain.model.ActivityLevel
import com.example.core.domain.model.Gender
import com.example.core.domain.model.GoalType
import com.example.core.domain.model.UserInfo
import com.example.core.domain.preference.IPreferences

class PreferencesImpl(
    private val sharedPref: SharedPreferences
) : IPreferences {
    override fun saveGender(gender: Gender) {
        sharedPref.edit().putString(IPreferences.KEY_GENDER, gender.name).apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit().putInt(IPreferences.KEY_AGE, age).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit().putFloat(IPreferences.KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit().putInt(IPreferences.KEY_HEIGHT, height).apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPref.edit().putString(IPreferences.KEY_ACTIVITY_LEVEL, level.name).apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPref.edit().putString(IPreferences.KEY_GOAL_TYPE, goalType.name).apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPref.edit().putFloat(IPreferences.KEY_CARB_RATIO, ratio).apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref.edit().putFloat(IPreferences.KEY_PROTEIN_RATIO, ratio).apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref.edit().putFloat(IPreferences.KEY_FAT_RATIO, ratio).apply()
    }

    override fun getUserInfo(): UserInfo {
        val age = sharedPref.getInt(IPreferences.KEY_AGE, -1)
        val height = sharedPref.getInt(IPreferences.KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(IPreferences.KEY_WEIGHT, -1f)
        val gender = sharedPref.getString(IPreferences.KEY_GENDER, null)
        val activityLevel = sharedPref.getString(IPreferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPref.getString(IPreferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPref.getFloat(IPreferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPref.getFloat(IPreferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPref.getFloat(IPreferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString(gender ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevel ?: "medium"),
            goalType = GoalType.valueOf(goalType ?: "MaintainWeight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }
}