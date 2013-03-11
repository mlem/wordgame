package wordgames.usecases

import spock.lang.Ignore
import spock.lang.IgnoreIf
import spock.lang.Specification
import wordgames.io.ResolutionStore

/**
 * Created with IntelliJ IDEA.
 * User: BeoXTC
 * Date: 11.03.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
class AddResolutionSpec extends Specification {

    def usecase = new AddResolution()
    def store = new ResolutionStore()

    def setup() {
        usecase.store = store
    }

    def "define by default locale"() {
        given:
        usecase.defaultLocale = Locale.ENGLISH

        when:
        usecase.define('key', 'value')

        then:
        store.get('key', Locale.ENGLISH) == 'value'
        !store.get('key', Locale.FRENCH)

    }

    def "define resolution by language"() {
        when:
        usecase.define('key', 'in english', Locale.ENGLISH)
        usecase.define('key', 'en francais', Locale.FRENCH)

        then:
        store.get('key', Locale.ENGLISH) == 'in english'
        store.get('key', Locale.FRENCH) == 'en francais'
    }

    def "define two resolutions"() {
        when:
        usecase.define('key1', 'in english1', Locale.ENGLISH)
        usecase.define('key2', 'in english2', Locale.ENGLISH)

        then:
        store.get('key1', Locale.ENGLISH) == 'in english1'
        store.get('key2', Locale.ENGLISH) == 'in english2'
    }
}
