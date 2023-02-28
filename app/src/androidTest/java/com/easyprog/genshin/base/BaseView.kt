package com.easyprog.genshin.base

import com.easyprog.genshin.fragments.artifacts.ArtifactsFragmentView
import com.easyprog.genshin.fragments.goals.GoalsFragmentView
import com.easyprog.genshin.fragments.hero_profile.HeroProfileFragmentView
import com.easyprog.genshin.fragments.hero_settings.HeroSettingsFragmentView
import com.easyprog.genshin.fragments.heroes.HeroesFragmentView
import com.easyprog.genshin.fragments.main.MainFragmentView

abstract class BaseView: BaseTest() {

    protected val artifactsFragmentView = ArtifactsFragmentView()
    protected val goalsFragmentView = GoalsFragmentView()
    protected val heroProfileFragmentView = HeroProfileFragmentView()
    protected val heroesFragmentView = HeroesFragmentView()
    protected val mainFragmentView = MainFragmentView()
    protected val heroSettingsFragmentView = HeroSettingsFragmentView()
}