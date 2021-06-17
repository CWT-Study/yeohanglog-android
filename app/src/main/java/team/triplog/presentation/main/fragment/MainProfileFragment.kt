package team.triplog.presentation.main.fragment

import android.Manifest
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import team.triplog.R
import team.triplog.databinding.FragmentMainProfileBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.util.event.EventObserver
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.util.launcher.PermissionLauncher
import team.triplog.presentation.viewmodel.ProfileViewModel
import team.triplog.presentation.viewmodel.UserViewModel


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class MainProfileFragment : BaseFragment<FragmentMainProfileBinding>(
    R.layout.fragment_main_profile
) {
    private val userViewModel: UserViewModel by sharedViewModel()
    private val profileViewModel: ProfileViewModel by sharedViewModel()

    private val permissionLauncher by lazy { PermissionLauncher() }


    override fun setup() {
        setupPermission()
        setupViewModel()
        setupView()
    }

    private fun setupPermission() {
        lifecycle.addObserver(permissionLauncher)
    }

    private fun setupViewModel() {
        binding.userViewModel = userViewModel
        binding.profileViewModel = profileViewModel

        profileViewModel.clickMoveSignIn.observe(
            viewLifecycleOwner, EventObserver {
                moveSignIn()
            }
        )

        profileViewModel.clickProfileImage.observe(
            viewLifecycleOwner, EventObserver {
                showCamera()
            }
        )
    }

    private fun setupView() {
        binding.clBtnSignIn.setupButton()
    }

    private fun showCamera() {
        permissionLauncher.launch(
            permission = Manifest.permission.CAMERA,
            granted = { startCamera() },
            explained = { showNeedPermissionAlert(getString(R.string.permission_camera)) }
        )
    }

    private fun startCamera() {
    }

    private fun moveSignIn() {
        // TODO : 로그인 페이지로 이동
        // TODO : 현재는 임시로 DB 에 User 정보가 생성되도록 설정
        userViewModel.signUp()
    }

    override fun onResume() {
        super.onResume()
        setTitle(getString(R.string.main_profile))
        setSettingButton(true)
    }

    override fun onStop() {
        super.onStop()
        setSettingButton(false)
    }
}