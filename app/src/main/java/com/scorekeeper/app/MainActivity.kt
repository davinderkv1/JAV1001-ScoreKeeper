package com.scorekeeper.app
/* I have chose two teams team a and team b, scores can be increased from 1 to 6 through */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import com.scorekeeper.app.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val teamAScore = findViewById<TextView>(id.teamA_score)
        val teamBScore = findViewById<TextView>(id.teamB_score)
        val scoreSelector = findViewById<Spinner>(id.score_increment)
        val scoreIncrease = findViewById<Button>(id.score_increase)
        val scoreDecrease = findViewById<Button>(id.score_decrease)
        val teamToggleButton = findViewById<Switch>(id.team_switch_button)

        // Setting initial scores to 0
        teamAScore.text = "0"
        teamBScore.text = "0"
        var currentTeam = 1


        // Added code code for toggle listener
        val onCheckedChangeListener = teamToggleButton.setOnCheckedChangeListener { _, isChecked ->
            currentTeam = if (isChecked) 2 else 1
        }
        // OnclickListeners to increase the values
        scoreIncrease.setOnClickListener {
            val scoreIncrement = scoreSelector.selectedItem.toString().toInt()
            if (currentTeam == 1) {
                val currentScore = teamAScore.text.toString().toInt()
                val newScore = currentScore + scoreIncrement
                teamAScore.text = newScore.toString()
            } else {
                val scoreIncrement = scoreSelector.selectedItem.toString().toInt()
                val currentScore = teamBScore.text.toString().toInt()
                val newScore = currentScore + scoreIncrement
                teamBScore.text = newScore.toString()
            }
        }
        // OnclickListeners to decrease the values
        scoreDecrease.setOnClickListener {
            val scoreIncrement = scoreSelector.selectedItem.toString().toInt()
            if (currentTeam == 1) {
                val scoreIncrement = scoreSelector.selectedItem.toString().toInt()
                val currentScore = teamAScore.text.toString().toInt()
                val newScore = currentScore - scoreIncrement
                if (newScore >= 0) {
                    teamAScore.text = newScore.toString()
                }
            } else {
                val scoreIncrement = scoreSelector.selectedItem.toString().toInt()
                val currentScore = teamBScore.text.toString().toInt()
                val newScore = currentScore - scoreIncrement
                if (newScore >= 0) {
                    teamBScore.text = newScore.toString()
                }
            }
        }
    }
}
