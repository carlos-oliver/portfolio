describe 'Caixa de Seleção', :dropdown do
    it 'Intem especifico simples' do
        visit 'http://training-wheels-protocol.herokuapp.com/dropdown'
        select('Loki', from: 'dropdown')
    end

    it 'Item específico com o find' do
        visit 'http://training-wheels-protocol.herokuapp.com/dropdown' 
        drop = find('.avenger-list')
        drop.find('option', text: 'Scott Lang').select_option
    end

    it 'Qualquer item' do
        visit 'http://training-wheels-protocol.herokuapp.com/dropdown'
        drop = find('.avenger-list')
        drop.all('option').sample.select_option 
    end
end