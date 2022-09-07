package app.movil.tarea0709;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import app.movil.tarea0709.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private EditText txt_number1, txt_number2, txt_res;
    private CheckBox ck_sum,ck_res,_ck_mul,ck_div;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        txt_number1 = (EditText) binding.txtNumber1;
        txt_number2 = (EditText) binding.txtNumber2;
        txt_res = (MultiAutoCompleteTextView) binding.txtRes;
        ck_res = (CheckBox) binding.ckRestar;
        ck_sum = (CheckBox) binding.ckSum;
        _ck_mul = (CheckBox) binding.ckMul;
        ck_div = (CheckBox) binding.ckDiv;


        return binding.getRoot();




    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.btnCalculate.setOnClickListener((View v)->{
            String sum = "";
            String res = "";
            String div = "";
            String mul = "";
            String respuesta = "";
            int ck = 0;

            if(ck_sum.isChecked()){
                 sum = sum();
                 ck = 1;
            }
            if (ck_res.isChecked()){
                res = sub();
                ck=1;
            }
            if (_ck_mul.isChecked()){
                mul = mul();
                ck=1;
            }
            if(ck_div.isChecked()){
                div = div();
                ck=1;
            }

            if (ck == 1) {
                respuesta = sum+"\n"+res+"\n"+mul+"\n"+div;

                txt_res.setText(respuesta);
            }else {
                showMessage();
            }
        });

    }


    public void showMessage() {
        Toast.makeText(this.getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
    }



    public String sum() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 + val_2;
        String res = String.valueOf(sum);
        String suma = "Resultado suma: "+res;

        return suma;
    }

    public String sub() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 - val_2;
        String res = String.valueOf(sum);

        String resta = "Resultado resta: "+res;
        return resta;
    }

    public String mul() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 * val_2;
        String res = String.valueOf(sum);
        String mult = "Resultado Multiplicacion: "+res;
        return mult;
    }

    public String div() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        String res = "";
        String div= "";
        if (val_2 != 0) {
            double sum = val_1 / val_2;
            res = String.valueOf(sum);
            div = "Resultado divicion: "+res;
            return div;
        } else {
            Toast.makeText(this.getContext(), "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
        }
        return div;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}