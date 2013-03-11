package wordgames.io

/**
 * Created with IntelliJ IDEA.
 * User: BeoXTC
 * Date: 11.03.13
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
class ResolutionStore {

    def map = [:]

    String get(String key, Locale language) {
        if (map[language]) {
            return map[language][key]
        }
        return
    }

    void put(String key, String value, Locale language) {
        if (!map[language])
            map[language] = [:]
        map[language][key] = value
    }
}
