package com.smart.clinic.feature.home

import com.smart.clinic.common.commonUi.baseViewMolde.BaseViewModel

class HomeViewModel : BaseViewModel<HomeState, HomeAction, HomeEffect>(HomeState()) {

    override fun onEachAction(action: HomeAction) {

//        when (action) {
//            is HomeAction.SelectTopLevelDestination -> {
//                setState {
//                    copy(
//                        bottomSheetItems = this.bottomSheetItems.map {
//                            if (it.route == action.selected.route) {
//                                it.isSelected = action.selected.isSelected
//                            } else {
//                                it.isSelected = false
//                            }
//                            it
//                        }
//                    )
//                }
//            }
//
//            else -> Unit
//        }
    }
}