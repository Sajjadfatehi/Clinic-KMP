package com.smart.clinic.feature.auth.register

import com.smart.clinic.common.commonUi.baseViewMolde.BaseViewModel

class RegisterViewModel : BaseViewModel<RegisterState, RegisterAction, RegisterEffect>(
    RegisterState()
) {

    override fun onEachAction(action: RegisterAction) {
        when (action) {
            is RegisterAction.OnFullNameChanged -> {
                setState {
                    copy(fullName = action.name)
                }
            }

            is RegisterAction.OnMedicalNumberChanged -> {
                setState {
                    copy(medicalNumber = action.medicalNumber)
                }
            }

            RegisterAction.OnRegisterInfoButtonClicked -> {

            }

            is RegisterAction.OnImageSelected -> {
                setState {
                    copy(image = action.imageByteArray)
                }
            }

            else -> Unit
        }
    }
}