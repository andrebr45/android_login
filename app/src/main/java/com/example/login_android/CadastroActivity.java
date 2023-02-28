package com.example.login_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.login_android.databinding.ActivityCadastroBinding;

public class CadastroActivity extends AppCompatActivity {

    ActivityCadastroBinding binding;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //BOTAO FINALIZAR CADASTRO
        binding.botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GUARDA DADOS DOS CAMPOS NAS VARIAVEIS
                String nome_var = binding.nome.getText().toString().trim();
                String telefone_var = binding.telefone.getText().toString().trim();
                String email_var = binding.email.getText().toString().trim();
                String senha_var = binding.senhaCadastro.getText().toString().trim();
                //SE CAMPOS VAZIOS
                if (nome_var.equals("") && telefone_var.equals("") && email_var.equals("")&& senha_var.equals("")){
                    Toast.makeText(CadastroActivity.this, "Campos Vazios", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CadastroActivity.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    intent = new Intent(CadastroActivity.this, LoginActivity.class);
                    //PEGA DADOS E LEVAM PARA A NOVA ACTIVITY
                    intent.putExtra("nome", nome_var);
                    intent.putExtra("telefone", telefone_var);
                    intent.putExtra("email", email_var);
                    intent.putExtra("senha", senha_var);
                    //INICIA NOVA ACTIVITY
                    startActivity(intent);
                    finish();;
                }
            }
        });
        //VOLTA PARA TELA LOGIN
        binding.fazerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
}
}
