package team.triplog.presentation.main.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.LogoutResponseCallback
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.BuildConfig
import team.triplog.R
import team.triplog.databinding.FragmentMainMoreBinding
import team.triplog.presentation.MoreUserActivity
import team.triplog.presentation.viewmodel.MainMoreViewModel
import team.triplog.presentation.signin.SignInActivity

class MainMoreFragment : Fragment() {
    private lateinit var binding: FragmentMainMoreBinding

    private val viewModel: MainMoreViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainMoreBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setUi()
        setup()

    }

    fun init() {
        binding.buttonProfileSetting.setOnClickListener(onClickListener)
        binding.layoutNoticeAppPush.setOnClickListener(onClickListener)
        binding.layoutNoticeAdvertising.setOnClickListener(onClickListener)
        binding.layoutSignOut.setOnClickListener(onClickListener)
    }

    private fun setUi() {
        binding.textVersion.text = getString(R.string.main_more_version, BuildConfig.VERSION_NAME)
    }

    private fun setup() {
        setViewModel()
    }

    fun setViewModel(){
        binding.viewModel = viewModel
    }


    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.button_profile_setting -> {
                val intent = Intent(context, MoreUserActivity::class.java)
                startActivity(intent)
            }
            R.id.layout_notice_app_push -> binding.switchNoticeAppPush.isChecked =
                !binding.switchNoticeAppPush.isChecked
            R.id.layout_notice_advertising -> binding.switchNoticeAdvertising.isChecked =
                !binding.switchNoticeAdvertising.isChecked
            R.id.layout_sign_out -> {
                val builder = AlertDialog.Builder(context)
                builder.setTitle(getString(R.string.pop_up_sign_out_title))
                builder.setMessage(getString(R.string.pop_up_sign_out_message))
                builder.setPositiveButton(
                    getString(R.string.button_ok)
                ) { dialog: DialogInterface?, which: Int ->
//                    realm?.executeTransactionAsync(
//                        { realm: Realm -> realm.delete(User::class.java) },
//                        { Log.i(":::::", "success !") }
//                    ) { error: Throwable -> Log.e(":::::", error.toString()) }
                    UserManagement.getInstance()
                        .requestLogout(object : LogoutResponseCallback() {
                            override fun onCompleteLogout() {
                                Intent(context, SignInActivity::class.java).apply {
                                    startActivity(this)
                                    activity?.finish()
                                }
                            }
                        })
                }
                builder.setNegativeButton(getString(R.string.button_cancel), null)
                builder.show()
            }
        }
    }


}