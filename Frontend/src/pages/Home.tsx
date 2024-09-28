import React, { useState } from 'react';
import { Box, Drawer, List, ListItem, ListItemText, Collapse, CssBaseline } from '@mui/material';
import { ExpandLess, ExpandMore } from '@mui/icons-material';
import CadastroPessoa from './CadastroPessoa';
import Relatorio from './Relatorio';

const drawerWidth = 240;

const Home: React.FC = () => {
  const [content, setContent] = useState<string>('home');
  const [open, setOpen] = useState<boolean>(false); // Estado para controlar a expansão da lista

  const renderContent = () => {
    switch (content) {
      case 'home':
        return <CadastroPessoa />;
      case 'relatorio':
        return <Relatorio />;
      default:
        return <CadastroPessoa />;
    }
  };

  const handleToggle = () => {
    setOpen(!open); // Alterna entre expandido e colapsado
  };

  return (
    <Box sx={{ display: 'flex', height: '100vh', overflow: 'hidden' }}>
      <CssBaseline />
      <Drawer
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          '& .MuiDrawer-paper': {
            width: drawerWidth,
            boxSizing: 'border-box',
          },
        }}
        variant="permanent"
        anchor="left"
      >
        <Box sx={{ overflow: 'auto' }}>
          <List>
            <ListItem onClick={handleToggle}>
              <ListItemText primary="Opções" />
              {open ? <ExpandLess /> : <ExpandMore />} {}
            </ListItem>

            <Collapse in={open} timeout="auto" unmountOnExit>
              <List component="div" disablePadding>
                <ListItem button sx={{ pl: 4 }} onClick={() => setContent('cadastro')}>
                  <ListItemText primary="Cadastro Pessoas" />
                </ListItem>
                <ListItem button sx={{ pl: 4 }} onClick={() => setContent('relatorio')}>
                  <ListItemText primary="Relatório" />
                </ListItem>
              </List>
            </Collapse>
          </List>
        </Box>
      </Drawer>
      <Box component="main" sx={{ flexGrow: 1, bgcolor: 'background.default', display: 'flex', flexDirection: 'column', overflow: 'auto' }}>
        {renderContent()}
      </Box>
    </Box>
  );
};

export default Home;
