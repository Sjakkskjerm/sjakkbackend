package no.ntnu.sjakkskjerm.livegame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateGameDemo {

    @Autowired
    LiveGameService service;

    private int step = 0;

    @Scheduled(fixedRate = 1000)
    public void updateGame() {
        ArrayList<String> pgnStepOne = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4"
        ));
        ArrayList<String> pgnStepTwo = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4 e5"
        ));
        ArrayList<String> pgnStepThree = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4 e5 2.Nf3"
        ));
        ArrayList<String> pgnStepFour = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4 e5 2.Nf3 Nc6"
        ));
        ArrayList<String> pgnStepFive = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4 e5 2.Nf3 Nc6 3.Bc4"
        ));
        ArrayList<String> pgnStepSix = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5"
        ));
        ArrayList<String> pgnStepSeven = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4"
        ));
        ArrayList<String> pgnStepEight = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4"
        ));
        ArrayList<String> pgnStepNine = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4 5.c3"
        ));
        ArrayList<String> pgnStepTen = new ArrayList<>(List.of(
                "[Event 'Casual Game']",
                "[Site 'Berlin GER']",
                "[Date '1852.??.??']",
                "[EventDate '?']",
                "[Round '?']",
                "[Result '1-0']",
                "[White 'Adolf Anderssen']",
                "[Black 'Jean Dufresne']",
                "[ECO 'C52']",
                "[WhiteElo '?']",
                "[BlackElo '?']",
                "[PlyCount '47']",
                "",
                "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4 5.c3 Ba5"));
        ArrayList<ArrayList<String>> pgnSteps = new ArrayList<ArrayList<String>>(List.of(
                pgnStepOne,
                pgnStepTwo,
                pgnStepThree,
                pgnStepFour,
                pgnStepFive,
                pgnStepSix,
                pgnStepSeven,
                pgnStepEight,
                pgnStepNine,
                pgnStepTen
        ));

        int maxSteps = pgnSteps.size();
        this.service.updateGame("301", pgnSteps.get(step));
        this.step++;
        if (step == maxSteps) {
            this.step = 0;
        }
    }
}