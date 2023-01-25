package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
               LoginApp()
            }
        }
    }
}

@Composable
fun LoginApp(

) {
    var username: String by remember { mutableStateOf("")}
    var password: String by remember { mutableStateOf("")}
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
                .padding(10.dp),
    ) {
        Text(
            text = "Login",
            color = MaterialTheme.colors.primary,
            fontSize = 24.sp,
            modifier = Modifier.padding(10.dp)
        )

            OutlinedTextField(
                value = username,
                onValueChange = {username = it},
                label = {Text(text = stringResource(R.string.username))},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.width(350.dp),
                trailingIcon = { Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon"
                )
                },
            )

            OutlinedTextField(
                value = password,
                onValueChange = {password = it },
                label = { Text(text = stringResource(R.string.password))},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.width(350.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = { Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Lock Icon"
                ) },

                )


        Button(onClick = { /*TODO*/ }) {
            Text(text = "Submit")
        }
    }
    
}