package com.example.bmi;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText weight, height;
    AppCompatButton button;
    TextView resultText, result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);
        resultText = findViewById(R.id.resultText);


    }

    public void calculateBMI(View view) {
        double weight_ = Double.parseDouble(weight.getText().toString());
        double height_ = Double.parseDouble(height.getText().toString());
        if (weight_ <= 0 || height_ <= 0) {
            resultText.setText("Введены неверные значения");
            resultText.setTextColor(Color.RED);
            weight.setText("");
            height.setText("");
            result.setText("");

        } else {
            double h_m = height_ / 100;
            double result_ = weight_ / (h_m * h_m);
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            String value = decimalFormat.format(result_);
            if (result_ <= 16) {
                resultText.setText("Выраженный дефицит массы тела.\nНеобходимо срочно обратиться к терапевту и эндокринологу для выявления причин недостаточности веса (возможные причины: нарушения обмена веществ, эндокринные заболевания, расстройства пищевого поведения).\nПод наблюдением врача-диетолога требуется высококалорийный рацион с повышенным содержанием белков, сложных углеводов и полезных жиров.\nПод руководством специалиста ЛФК для укрепления мышц и улучшения аппетита, но без перерасхода калорий.");
            } else if (16 < result_ && result_ <= 18.5) {
                resultText.setText("Недостаточная масса тела.\nРекомендуется визит к терапевту.\nВрач поможет определить, является ли низкий вес вашей индивидуальной нормой или есть скрытые проблемы.\nТакже следует проконсультироваться с диетологом для составления сбалансированного рациона с достаточной калорийностью для плавного набора мышечной, а не жировой массы.");
            } else if (18.5 < result_ && result_ <= 25) {
                resultText.setText("Норма.\nПоддерживайте текущий вес. Это самый здоровый диапазон, и ваша задача — сохранить его.\nПридерживайтесь принципов здорового питания: разнообразный рацион, богатый овощами, фруктами, цельнозерновыми продуктами и белком.\\nРегулярная физическая активность. Не менее 150 минут умеренной или 75 минут интенсивной аэробной нагрузки в неделю.");
            } else if (25 < result_ && result_ <= 30) {
                resultText.setText("Избыточная масса тела.\nРекомендуется консультация терапевта и диетолога.\nЭто критический момент, когда можно предотвратить развитие ожирения.\nНачните с уменьшения порций, отказа от вредной пищи(сладости, фастфуд, сладкие напитки), увеличения доли клетчатки и белка.\nУвеличьте физическую активность. Найдите вид активности по душе (ходьба, плавание, велосипед, танцы) и занимайтесь регулярно.");
            } else if (30 < result_ && result_ <= 35) {
                resultText.setText("Ожирение первой степени.\nОбязательно обратитесь к врачу (терапевт, эндокринолог).\nНеобходимо оценить риски для здоровья (артериальное давление, уровень сахара и холестерина в крови).\nКонсультация диетолога обязательна. Требуется индивидуальный и устойчивый план питания для снижения веса.\nНачните с щадящих нагрузок (ходьба, плавание), возможно, с инструктором ЛФК, чтобы не навредить суставам.nЧасто необходима для выявления и коррекции пищевых привычек и поведения.");
            } else if (35 < result_ && result_ <= 40) {
                resultText.setText("Ожирение второй степени.\nНезамедлительно обратитесь к врачу.\nВысокий риск сопутствующих заболеваний (диабет 2-го типа, гипертония, апноэ сна).\nНеобходимо комплексное лечение под медицинским наблюдением: включает строгую диетотерапию, лечебную физкультуру и, часто, медикаментозную терапию.\nРассмотрите вопрос о бариатрической операции.");
            } else if (result_ >= 40) {
                resultText.setText("Ожирение третьей степени.\nТребуется срочное и серьезное медицинское вмешательство.\nОбратитесь к бариатрическому хирургу и эндокринологу. Бариатрическая операция часто является наиболее эффективным и рекомендованным методом лечения для значительного и устойчивого снижения веса и улучшения здоровья.\nПодход должен быть комплексным. Даже при рассмотрении операции, необходима работа с диетологом, психологом и другими специалистами для подготовки и успешной реабилитации.");
            }
            result.setText("Ваш ИМТ: " + value);
            resultText.setTextColor(Color.WHITE);
        }
    }
}

















