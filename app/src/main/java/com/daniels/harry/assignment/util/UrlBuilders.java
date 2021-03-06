package com.daniels.harry.assignment.util;


import com.daniels.harry.assignment.constant.Constants;
import com.daniels.harry.assignment.jsonobject.FixtureJson;


//static methods for building api url's from endpoints and filters
public class UrlBuilders {

    public static String serialiseString(String s){
        return s.replace(" ", Constants.SERIALISE_URL_SPACE);
    }

    public static String buildFixtureApiUrls(String endpoint, int matchday, boolean isNext){
        if (!isNext)
            matchday--;

        return endpoint + matchday;
    }

    public static String buildCrestApiUrls(String endpoint, String favTeamName, FixtureJson prev, FixtureJson next){
        String prevOppositionName = Calculators.calculateOppositionName(favTeamName, prev.getHomeTeamName(), prev.getAwayTeamName());
        String nextOppositionName = Calculators.calculateOppositionName(favTeamName, next.getHomeTeamName(), next.getAwayTeamName());

        prevOppositionName = serialiseString(prevOppositionName);
        nextOppositionName = serialiseString(nextOppositionName);

        return endpoint.replace(Constants.URL_SLUG_REPLACE_PREV, prevOppositionName)
                .replace(Constants.URL_SLUG_REPLACE_NEXT, nextOppositionName);
    }

    public static String buildPlayerApiUrl(String id, String url) {
        return url.replace(Constants.URL_SLUG_REPLACE_ID, id);
    }
}
