package wordgames.usecases

/**
 * Created with IntelliJ IDEA.
 * User: BeoXTC
 * Date: 11.03.13
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
class AddResolution {


    def store
    def defaultLocale

    def define(String key, String value) {
        store.put(key, value, defaultLocale)
    }

    def define(String key, String value, Locale language) {
        store.put(key, value, language)
    }
}
