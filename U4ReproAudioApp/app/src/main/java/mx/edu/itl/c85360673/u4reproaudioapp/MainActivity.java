package mx.edu.itl.c85360673.u4reproaudioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button btnFiesta;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFiesta = findViewById ( R.id.btnFiesta );
        btnFiesta.setOnTouchListener ( this );

        //Establece el canal de audio para musica
        setVolumeControlStream ( AudioManager.STREAM_MUSIC );
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if ( v.getId () == R.id.btnFiesta ) {
            switch ( event.getAction() ) {
                case MotionEvent.ACTION_DOWN:
                    //Se presiono el boton
                    reproduccir_audio ();
                    break;
                case MotionEvent.ACTION_UP:
                    //Se dejo de presionar
                    detener_audio ();
                    break;
            }
        }
        return true;
    }

    private void detener_audio() {
        if ( mediaPlayer != null ) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    private void reproduccir_audio() {
        if ( mediaPlayer == null ) {
            mediaPlayer = MediaPlayer.create ( this, R.raw.rickroll );
            mediaPlayer.start();
        }
    }

    public void btnAcercadeClick ( View v ) {
        Intent intent  = new Intent ( this, AcercaDe.class );
        startActivity ( intent );
        finish();
    }

}