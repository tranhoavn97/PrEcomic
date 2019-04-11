package com.example.developer.precomic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.developer.precomic.Model.User.ModelUser;
import com.example.developer.precomic.Object.User;

public class ResgiterActivity extends AppCompatActivity {
    EditText edtUsername,edtFullname,edtPassword;
    Button btnRegister;
    String Username,Fullname,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgiter);
        edtFullname=findViewById(R.id.edtFullname);
        edtPassword=findViewById(R.id.edtPassword);
        edtUsername=findViewById(R.id.edtUsername);
        btnRegister=findViewById(R.id.btnRegister);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });

    }

    private void Register() {

        boolean check=true;

        Username=edtUsername.getText().toString().trim();
        Fullname=edtFullname.getText().toString().trim();
        Password=edtPassword.getText().toString().trim();




        if(Fullname.equals("") || Fullname==null)
        {
            Toast.makeText(this, "yêu cầu thông tin fullname", Toast.LENGTH_SHORT).show();
            check=false;
        }
        else if(Username.equals("") || Username==null)
        {
            Toast.makeText(this, "yêu cầu thông tin username", Toast.LENGTH_SHORT).show();
            check=false;
        }
        else if(Password.equals("") || Password==null)
        {
            Toast.makeText(this, "yêu cầu thông tin password", Toast.LENGTH_SHORT).show();
            check=false;
        }

        if(check)
        {

            User user=new User();
            user.setFullname(edtFullname.getText().toString().trim());
            user.setPassword(edtPassword.getText().toString());
            user.setUsername(edtUsername.getText().toString());
            boolean kiemtra=new ModelUser().RegisterMember(user);
            if(kiemtra)
            {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ResgiterActivity.this,LoginActivity.class));
            }
            else {
                Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
            }



        }


    }
}
