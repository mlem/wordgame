package wordgames.usecases

/**
 * Created with IntelliJ IDEA.
 * User: BeoXTC
 * Date: 11.03.13
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 */
class ResolveWord {
    def store
    def defaultLanguage

    String resolve(String key) {
        resolve(key,defaultLanguage)
    }
    String resolve(String key, Locale language) {
        store.get(key, language) ?: '???key???'
    }
}
