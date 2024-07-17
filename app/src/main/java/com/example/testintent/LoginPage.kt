package com.example.testintent
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class LoginPage : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var age: EditText
    private lateinit var job: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginpage)
        name = findViewById(R.id.edittextname)
        email = findViewById(R.id.editemail)
        age = findViewById(R.id.editage)
        job = findViewById(R.id.editjob)
        val submit = findViewById<Button>(R.id.submit)
        val backBtn = findViewById<ImageButton>(R.id.back)
        val linkedInBtn = findViewById<LinearLayout>(R.id.linkedIn)
        val gitHubBtn = findViewById<LinearLayout>(R.id.github)
        val facebookBtn = findViewById<LinearLayout>(R.id.facebook)
        linkedInBtn.setOnClickListener {
            openLinkedIn()
        }
        gitHubBtn.setOnClickListener{
            openGitHub()
        }
        facebookBtn.setOnClickListener{
            openFaceBook()
        }
        backBtn.setOnClickListener {
            finish()
        }
        submit.setOnClickListener(){
            val name1 = name.text.toString().trim()
            val email1 = email.text.toString().trim()
            val age1 = age.text.toString().trim()
            val job1 = job.text.toString().trim()

            // Input validation (example)
            if (name1.isEmpty() || email1.isEmpty() || age1.isEmpty() || job1.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
         Toast.makeText(
                this,
                "My name is: ${name.text},\nemail is: ${email.text},\nage is: ${age.text},\nand my job is: ${job.text}",
                Toast.LENGTH_LONG
            ).show()
            clearData()
        }




    }
    private fun clearData() {
        name.text.clear()
        email.text.clear()
        age.text.clear()
        job.text.clear()
    }
   private fun openFaceBook() {
       startActivity(
           Intent(
               Intent.ACTION_VIEW,
               Uri.parse("https://www.facebook.com/profile.php?id=61556941828639")
           )
       )
   }

    private fun openGitHub(){
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/mohamedSolaiman11")
                )
            )

    }
    private fun openLinkedIn(){
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/mohamed-solaiman-a2b9921b4")
                )
            )

    }



}
