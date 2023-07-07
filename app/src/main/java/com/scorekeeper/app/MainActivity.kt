package com.scorekeeper.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamBScoreTextView: TextView
    private lateinit var scoreSelectorSpinnerA: Spinner
    private lateinit var scoreSelectorSpinnerB: Spinner
    private lateinit var scoreIncreaseButtonA: Button
    private lateinit var scoreIncreaseButtonB: Button
    private lateinit var scoreDecreaseButtonA: Button
    private lateinit var scoreDecreaseButtonB: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // References to UI elements
        teamAScoreTextView = findViewById(R.id.teamA_score)
        teamBScoreTextView = findViewById(R.id.teamB_score)
        scoreSelectorSpinnerA = findViewById(R.id.score_incrementA)
        scoreSelectorSpinnerB = findViewById(R.id.score_incrementB)
        scoreIncreaseButtonA = findViewById(R.id.teamA_increment)
        scoreIncreaseButtonB = findViewById(R.id.teamB_increment)
        scoreDecreaseButtonA = findViewById(R.id.teamA_decrement)
        scoreDecreaseButtonB = findViewById(R.id.teamB_decrement)

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
