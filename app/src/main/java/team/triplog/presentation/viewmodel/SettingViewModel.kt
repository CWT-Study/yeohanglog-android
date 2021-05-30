package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.presentation.base.BaseViewModel
import team.triplog.presentation.main.setting.SettingMenu
import team.triplog.presentation.util.event.Event


/**
 * @author mjkim
 * @since 2021.05.30
 */
class SettingViewModel : BaseViewModel() {

    private val _eventClickMenu = MutableLiveData<Event<SettingMenu>>()
    val eventClickMenu: LiveData<Event<SettingMenu>>
        get() = _eventClickMenu


    fun clickMenu(menu: SettingMenu) {
        _eventClickMenu.value = Event(menu)
    }
}
