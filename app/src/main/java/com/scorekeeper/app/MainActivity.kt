package com.scorekeeper.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // References to UI elements
        val teamAScoreTextView = findViewById<TextView>(R.id.teamA_score)
        val teamBScoreTextView = findViewById<TextView>(R.id.teamB_score)
        val scoreSelectorSpinnerA = findViewById<Spinner>(R.id.score_incrementA)
        val scoreSelectorSpinnerB = findViewById<Spinner>(R.id.score_incrementB)
        val scoreIncreaseButtonA = findViewById<Button>(R.id.teamA_increment)
        val scoreIncreaseButtonB = findViewById<Button>(R.id.teamB_increment)
        val scoreDecreaseButtonA = findViewById<Button>(R.id.teamA_decrement)
        val scoreDecreaseButtonB = findViewById<Button>(R.id.teamB_decrement)

        // Setting initial scores to 0
        teamAScoreTextView.text = "0"
        teamBScoreTextView.text = "0"

        // OnClickListener to increase the scores for Team A
        scoreIncreaseButtonA.setOnClickListener {
            val scoreIncrement = scoreSelectorSpinnerA.selectedItem.toString().toInt()
            val currentScore = teamAScoreTextView.text.toString().toInt()
            val newScore = currentScore + scoreIncrement
            teamAScoreTextView.text = newScore.toString()
        }

        // OnClickListener to decrease the scores for Team A
        scoreDecreaseButtonA.setOnClickListener {
            val scoreIncrement = scoreSelectorSpinnerA.selectedItem.toString().toInt()
            val currentScore = teamAScoreTextView.text.toString().toInt()
            val newScore = currentScore - scoreIncrement
            if (newScore >= 0) {
                teamAScoreTextView.text = newScore.toString()
            }
        }

        // OnClickListener to increase the scores for Team B
        scoreIncreaseButtonB.setOnClickListener {
            val scoreIncrement = scoreSelectorSpinnerB.selectedItem.toString().toInt()
            val currentScore = teamBScoreTextView.text.toString().toInt()
            val newScore = currentScore + scoreIncrement
            teamBScoreTextView.text = newScore.toString()
        }

        // OnClickListener to decrease the scores for Team B
        scoreDecreaseButtonB.setOnClickListener {
            val scoreIncrement = scoreSelectorSpinnerB.selectedItem.toString().toInt()
            val currentScore = teamBScoreTextView.text.toString().toInt()
            val newScore = currentScore - scoreIncrement
            if (newScore >= 0) {
                teamBScoreTextView.text = newScore.toString()
            }
        }
    }
}
