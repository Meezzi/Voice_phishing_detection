//package com.example.YourVoice;
//
//import com.microsoft.cognitiveservices.speech.*;
//import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//
//public class MicroSTT {
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        SpeechConfig speechConfig = SpeechConfig.fromSubscription("<paste-your-subscription-key>", "<paste-your-region>");
//        fromFile(speechConfig);
//
//        // Starts continuous recognition. Uses StopContinuousRecognitionAsync() to stop recognition.
//        recognizer.startContinuousRecognitionAsync().get();
//
//// Waits for completion.
//        stopTranslationWithFileSemaphore.acquire();
//
//// Stops recognition.
//        recognizer.stopContinuousRecognitionAsync().get();
//    }
//
//    public static void fromFile(SpeechConfig speechConfig) throws InterruptedException, ExecutionException {
//        AudioConfig audioConfig = AudioConfig.fromWavFileInput("YourAudioFile.wav");
//        SpeechRecognizer recognizer = new SpeechRecognizer(speechConfig, audioConfig);
//
//        Future<SpeechRecognitionResult> task = recognizer.recognizeOnceAsync();
//        SpeechRecognitionResult result = task.get();
//        System.out.println("RECOGNIZED: Text=" + result.getText());
//
//
//        switch (result.getReason()) {
//            case ResultReason.RecognizedSpeech:
//                System.out.println("We recognized: " + result.getText());
//                exitCode = 0;
//                break;
//            case ResultReason.NoMatch:
//                System.out.println("NOMATCH: Speech could not be recognized.");
//                break;
//            case ResultReason.Canceled: {
//                CancellationDetails cancellation = CancellationDetails.fromResult(result);
//                System.out.println("CANCELED: Reason=" + cancellation.getReason());
//
//                if (cancellation.getReason() == CancellationReason.Error) {
//                    System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
//                    System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
//                    System.out.println("CANCELED: Did you set the speech resource key and region values?");
//                }
//            }
//            break;
//        }
//    }
//
//    public void onError(int error) {
//        String message;
//
//
//    }
//
//}