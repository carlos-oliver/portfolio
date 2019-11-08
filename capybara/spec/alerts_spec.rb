# encoding: utf-8
describe 'Alertas de JS', :alerts do
    before(:each) do
        visit 'http://training-wheels-protocol.herokuapp.com/javascript_alerts'
    end

    it 'alerta' do
        click_button 'Alerta'

        msg = page.driver.browser.switch_to.alert.text

        expect(msg).to eql 'Isto é uma mensagem de alerta'
    end

    it 'sim confirma' do
        click_button 'Confirma'
        msg = page.driver.browser.switch_to.alert.text
        expect(msg).to eql 'E ai confirma?'

        page.driver.browser.switch_to.alert.accept
        expect(page).to have_content 'Mensagem confirmada'
    end

    it 'não confirma' do
        click_button 'Confirma'

        msg = page.driver.browser.switch_to.alert.text
        expect(msg).to eql 'E ai confirma?'

        page.driver.browser.switch_to.alert.accept
        expect(page).to have_content 'Mensagem não confirmada'
    end
end