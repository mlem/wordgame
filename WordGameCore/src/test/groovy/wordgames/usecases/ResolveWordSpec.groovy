package wordgames.usecases

import spock.lang.Ignore
import spock.lang.Specification
import wordgames.io.ResolutionStore

class ResolveWordSpec extends Specification {


    ResolveWord usecase = new ResolveWord()
    def store = new ResolutionStore()

    def setup() {
        usecase.store = store
    }

    def "resolve when no associations available"() {
        given:
        usecase.defaultLanguage = Locale.ENGLISH

        expect:
        usecase.resolve('key') == '???key???'
    }

    def "resolve when an association is given"() {
        given:
        usecase.defaultLanguage = Locale.ENGLISH

        when:
        store.put('key', 'resolved key', Locale.ENGLISH)

        then:
        usecase.resolve('key') == 'resolved key'
    }

    def "resolve by language"() {
        given:
        store.put('key', 'in english', Locale.ENGLISH)
        store.put('key', 'en francais', Locale.FRENCH)

        expect:
        usecase.resolve('key', Locale.ENGLISH) == 'in english'
        usecase.resolve('key', Locale.FRENCH) == 'en francais'

    }
}
