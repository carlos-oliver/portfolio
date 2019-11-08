describe 'Botões de Radio', :radio do
    before(:each) do
        visit 'http://training-wheels-protocol.herokuapp.com/radios'
    end

    it 'seleção por ID' do
        choose('cap')
    end

    it 'seleção popr find e css selector' do
        find('input[value=guardians]').click
    end

    after(:each)do
        sleep 3
    end
end