package pl.edu.icm.cermine.metadata.zoneclassification.features;

import pl.edu.icm.cermine.structure.model.*;
import pl.edu.icm.cermine.tools.classification.features.FeatureCalculator;

/**
 *
 * @author Dominika Tkaczyk (d.tkaczyk@icm.edu.pl)
 */
public class LetterCountFeature extends FeatureCalculator<BxZone, BxPage> {

    @Override
    public double calculateFeatureValue(BxZone zone, BxPage page) {
        int count = 0;
        for (BxLine line : zone.getLines()) {
            for (BxWord word : line.getWords()) {
                for (BxChunk chunk : word.getChunks()) {
                    char[] arr = chunk.getText().toCharArray();
                    for (int i = 0; i < arr.length; i++) {
                        if (Character.isLetter(arr[i])) {
                            count++;
                        }
                    }
                }
            }
        }
        return (double) count;
    }
}