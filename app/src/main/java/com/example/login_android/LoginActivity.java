package com.example.login_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.login_android.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String nome_cadastro = intent.getStringExtra("nome");
        String telefone_cadastro = intent.getStringExtra("telefone");
        String email_cadastro = intent.getStringExtra("email");
        String senha_cadastro = intent.getStringExtra("senha");

        //LOGAR
        binding.botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GUARDA DADOS DOS CAMPOS NAS VARIAVEIS
                String usuario = binding.user.getText().toString().trim();
                String senha = binding.senha.getText().toString().trim();
                //SE CAMPOS VAZIOS
                if (usuario.equals("") &&(senha.equals(""))){
                    Toast.makeText(LoginActivity.this, "Campos vazios", Toast.LENGTH_SHORT).show();
                }else{
                    //MÉTODO DE LOGIN/ USAR FIREBASE NO LUGAR/ É APENAS UM TESTE
                    if ((usuario.equals(nome_cadastro) || usuario.equals(email_cadastro)) && (senha.equals(senha_cadastro))){
                        Toast.makeText(LoginActivity.this, "Logado com Sucesso", Toast.LENGTH_SHORT).show();
                        //PEGA DADOS E LEVAM PARA A NOVA ACTIVITY
                        Intent intent = new Intent(LoginActivity.this, ClienteActivity.class);
                        intent.putExtra("nome_c",nome_cadastro);
                        intent.putExtra("telefone_c", telefone_cadastro);
                        intent.putExtra("email_c",email_cadastro);
                        intent.putExtra("senha_c", senha_cadastro);
                        startActivity(intent);
                        finish();
                    } else{
                        Toast.makeText(LoginActivity.this, "E-mail ou Senha incorreto", Toast.LENGTH_SHORT).show();
                    }
                    limpaCampoLogin();
                }
            }

            private void limpaCampoLogin() {
                binding.user.setText("");
                binding.senha.setText("");
            }
        });
        //CADASTRAR
        binding.cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}