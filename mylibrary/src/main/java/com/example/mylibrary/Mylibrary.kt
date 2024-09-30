package com.example.mylibrary

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Mylibrary {

    fun showToast(context: Context, message: String) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun MyLibraryUI() {
        Column {
            // A simple state to manage button clicks
            Row { phoneTextField() }
            Row { passwordTextField() }
            Row { LoginButton() }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun PreviewMyLibraryUI() {
        MyLibraryUI() // Show the UI preview in the IDE
    }
    @Composable
    private fun passwordTextField() {
        var text by remember { mutableStateOf("") }
        text=vIEWMODEL.typedpassword.value
        // TextField to accept user input
        TextField(
            value = text, // The current value of the text
            onValueChange = { newText -> text = newText
                vIEWMODEL.typedpassword.value=newText
//                vIEWMODEL.fetchData(newText)
            }, // Callback to update the state with new text
            label = { Text(vIEWMODEL.passwordlabel) }, // Label for the text field
            placeholder = { Text(vIEWMODEL.passwordlabel) }, // Placeholder text
            singleLine = true, // Make it single-line
            modifier = Modifier
                .padding(16.dp) // Modifier for styling (padding, etc.)
                .fillMaxWidth() // Take up the full width of the parent
        )
    }
}

@Composable
fun phoneTextField() {
    // State to hold the text entered by the user
    var text by remember { mutableStateOf("") }
    text=vIEWMODEL.typedphoneno.value
    // TextField to accept user input
    TextField(
        value = text, // The current value of the text
        onValueChange = { newText -> text = newText
            vIEWMODEL.typedphoneno.value=newText
//                vIEWMODEL.fetchData(newText)
        }, // Callback to update the state with new text
        label = { Text(vIEWMODEL.phonenolabel) }, // Label for the text field
        placeholder = { Text(vIEWMODEL.phonenolabel) }, // Placeholder text
        singleLine = true, // Make it single-line
        modifier = Modifier
            .padding(16.dp) // Modifier for styling (padding, etc.)
            .fillMaxWidth() // Take up the full width of the parent
    )
}
@Composable
fun LoginButton() {
    var buttonText by remember { mutableStateOf(vIEWMODEL.login) }

    Button(
        onClick = {
            vIEWMODEL.Autenticateuser()

        },
        modifier = Modifier.padding(16.dp) // Add padding to the button
    ) {
        Text(text = buttonText)
    }

}
