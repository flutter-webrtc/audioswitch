package com.twilio.audioswitch

import android.annotation.SuppressLint
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.AudioManager.OnAudioFocusChangeListener

internal class AudioFocusRequestWrapper {

    @SuppressLint("NewApi")
    fun buildRequest(
        audioFocusChangeListener: OnAudioFocusChangeListener,
        focusMode: Int = AudioManager.AUDIOFOCUS_GAIN_TRANSIENT
    ): AudioFocusRequest {
        val playbackAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_VOICE_COMMUNICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()
        return AudioFocusRequest.Builder(focusMode)
            .setAudioAttributes(playbackAttributes)
            .setAcceptsDelayedFocusGain(true)
            .setOnAudioFocusChangeListener(audioFocusChangeListener)
            .build()
    }
}
