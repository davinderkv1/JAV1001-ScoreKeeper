package com.scorekeeper.app

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamBScoreTextView: TextView
    private lateinit var scoreSelectorSpinnerA: Spinner
    private lateinit var scoreSelectorSpinnerB: Spinner
    private lateinit var scoreIncreaseButtonA: Button
    private lateinit var scoreIncreaseButtonB: Button
    private lateinit var scoreDecreaseButtonA: Button
    private lateinit var scoreDecreaseButtonB: Button
    private lateinit var toolbarMenuIcon: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("ScoreKeeperPrefs", MODE_PRIVATE)

        teamAScoreTextView = findViewById(R.id.teamA_score)
        teamBScoreTextView = findViewById(R.id.teamB_score)
        scoreSelectorSpinnerA = findViewById(R.id.score_incrementA)
        scoreSelectorSpinnerB = findViewById(R.id.score_incrementB)
        scoreIncreaseButtonA = findViewById(R.id.teamA_increment)
        scoreIncreaseButtonB = findViewById(R.id.teamB_increment)
        scoreDecreaseButtonA = findViewById(R.id.teamA_decrement)
        scoreDecreaseButtonB = findViewById(R.id.teamB_decrement)
        toolbarMenuIcon = findViewById(R.id.toolbar_menu_icon)

        val savedScoreTeamA = sharedPreferences.getInt("teamAScore", 0)
        val savedScoreTeamB = sharedPreferences.getInt("teamBScore", 0)

        teamAScoreTextView.text = savedScoreTeamA.toString()
        teamBScoreTextView.text = savedScoreTeamB.toString()

        scoreIncreaseButtonA.setOnClickListener {
            val scoreIncrement = scoreSelectorSpinnerA.selectedItem.toString().toInt()
            val currentScore = teamAScoreTextView.text.toString().toInt()
            val newScore = currentScore + scoreIncrement
            teamAScoreTextView.text = newScore.toString()
            sharedPreferences.edit().putInt("teamAScore", newScore).apply()
        }

        scoreDecreaseButtonA.setOnClickListener {
            val scoreIncrement = scoreSelectorSpinnerA.selectedItem.toString().toInt()
            val currentScore = teamAScoreTextView.text.toString().toInt()
            val newScore = currentScore - scoreIncrement
            if (newScore >= 0) {
                teamAScoreTextView.text = newScore.toString()
                sharedPreferences.edit().putInt("teamAScore", newScore).apply()
            }
        }

        scoreIncreaseButtonB.setOnClickListener {
            val scoreIncrement = scoreSelectorSpinnerB.selectedItem.toString().toInt()
            val currentScore = teamBScoreTextView.text.toString().toInt()
            val newScore = currentScore + scoreIncrement
            teamBScoreTextView.text = newScore.toString()
            sharedPreferences.edit().putInt("teamBScore", newScore).apply()
        }

        scoreDecreaseButtonB.setOnClickListener {
            val scoreIncrement = scoreSelectorSpinnerB.selectedItem.toString().toInt()
            val currentScore = teamBScoreTextView.text.toString().toInt()
            val newScore = currentScore - scoreIncrement
            if (newScore >= 0) {
                teamBScoreTextView.text = newScore.toString()
                sharedPreferences.edit().putInt("teamBScore", newScore).apply()
            }
        }

        toolbarMenuIcon.setOnClickListener { view ->
            showOptionsMenu(view)
        }
    }

    private fun showOptionsMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.options_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_settings -> {
                    sharedPreferences.edit().clear().apply()
                    teamAScoreTextView.text = "0"
                    teamBScoreTextView.text = "0"
                    true
                }
                R.id.menu_about -> {
                    showToast("Developers: Gokul, Kamal, Davinder,  Course Code: JAV1001")
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
